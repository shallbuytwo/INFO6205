# Common classes definitions
class Node:
	# for populate left
	def __init__(self, val=0, left=None, right=None, nextLeft=None):
		self.val = val
		self.left = left
		self.right = right
		self.nextLeft = nextLeft

class TreeNode:
	# for populating parent
	def __init__(self, val=0, left=None, right=None, parent=None):
		self.val = val
		self.left = left
		self.right = right
		self.parent = parent

class ListNode:
	def __init__(self, val=0, next=None):
		self.val = val
		self.next = next

# Q1
# Time complexity O(n) - all nodes need to be examined
# Space complexity is O(n) - # of nodes in the queue is related to n.
from collections import deque
def connect(root):
	if not root:
		return None
	que = deque([root])
	
	while que:
		tail = None
		n = len(que)
		for _ in range(n):
			cur = que.popleft()
			if tail:
				tail.nextLeft = cur
			tail = cur
			if cur.right:
				que.append(cur.right)     
			if cur.left:
				que.append(cur.left)
	return root

def q1Test():
	root = Node(1)
	root.left = Node(2)
	root.right = Node(3)
	root.left.left = Node(4)
	root.left.right = Node(5)
	root.right.left = Node(6)
	root.right.right = Node(7)
	root.left.left.left = Node(8)
	root.left.right.left = Node(9)
	root.right.left.right = Node(10)
	root.right.right.right = Node(11)
	connect(root)
	print("Q1 done")

# Q2
# Time complexity O(n) - all nodes need to be examined
# Space complexity is: average O(lgn), worse O(n), depending on the balance of the tree. 
def populateParent(root):
	if not root:
		return
	# handle the special case of root, whose parent is itself
	root.parent = root
	populateParentHelper(root)

def populateParentHelper(root):
	if not root:
		return
	if root.left:
		root.left.parent = root
	if root.right:
		root.right.parent = root
	populateParentHelper(root.left)
	populateParentHelper(root.right)

def q2Test():
	root = TreeNode(1)
	root.left = TreeNode(2)
	root.right = TreeNode(3)
	root.left.right = TreeNode(4)
	root.right.left = TreeNode(5)
	populateParent(root)
	print("Q2 done")

# Q3
# Time complexity O(n) - worst case we need to examine the whole tree
# Space complexity is: average O(lgn), worse O(n), depending on the balance of the tree.
def printValuesInRange(root, lRange, rRange):
	if not root:
		return
	# if there are values we need to examine in the left tree
	if lRange < root.val:
		printValuesInRange(root.left, lRange, rRange)
	# if root's value is in range
	if lRange <= root.val and root.val <= rRange:
		print(str(root.val) + " ")
	# examine the right tree
	printValuesInRange(root.right, lRange, rRange)

def q3Test():
	root = TreeNode(8)
	root.left = TreeNode(3)
	root.right = TreeNode(10)
	root.left.left = TreeNode(1)
	root.left.right = TreeNode(6)
	root.right.right = TreeNode(14)
	root.left.right.left = TreeNode(4)
	root.right.right.left = TreeNode(13)
	root.right.right.right = TreeNode(17)
	# This should print 6, 8, 10, 13, 14
	# Note: the sample tree given in the java file isn't even a bst. 
	# Please refer to the above tree for a correct test.
	printValuesInRange(root, 5, 16)
	print("Q3 done")

# Q4
class SortedList:
	# O(1)
	def __init__(self):
		self.dummy = ListNode(-1)
		self.length = 0

	# O(1)
	def getList(self):
		return self.dummy.next

	# O(1)
	def getLength(self):
		return self.length

	# O(n)
	def insert(self, intVal):
		prev = self.dummy

		while prev.next and prev.next.val <= intVal:
			prev = prev.next

		nn = prev.next
		newNode = ListNode(intVal)
		prev.next = newNode
		newNode.next = nn

		self.length += 1

def q4Test():
	sl = SortedList()
	sl.insert(5)
	sl.insert(3)
	sl.insert(7)
	sl.insert(4)
	sl.insert(6)
	sl.insert(9)
	curr = sl.getList()
	while curr:
		print(curr.val)
		curr = curr.next
	print("Q4 done")

# Q5
# Time complexity O(klgn) - where n is # of elements in arr, and k is # of elements in values. For each value, we need to do a binary search.
# Space complexity O(1) if we don't count the space to store the final result. If we count that it is O(k) - same with the size of values.
def getStartOfEachValues(arr, values):
	if len(arr) == 0 or len(values) == 0:
		return []
	res = []
	# for each value we do binary search
	for value in values:
		l = 0
		r = len(arr) - 1
		while l < r:
			m = l + (r - l) // 2
			if arr[m] < value:
				l = m + 1
			else:
				r = m
		if arr[l] != value:
			# the value doesn't exist in arr
			res.append(-1)
		else:
			res.append(l)
	return res

def q5Test():
	arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
	values = [1,4,5,10]
	res = getStartOfEachValues(arr, values)
	# Note: the expected output is [5,-1,11,16]. The sample java seems to have a wrong example.
	print(",".join(str(x) for x in res))
	print("Q5 done")

if __name__ == "__main__":
	q1Test()
	q2Test()
	q3Test()
	q4Test()
	q5Test()
