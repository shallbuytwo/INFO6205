
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
    	self.val = val
    	self.left = left
        self.right = right


# Q1

def reverse(nums, start, end):
    while start < end:
        nums[start], nums[end] = nums[end], nums[start]
        start += 1
        end -= 1
def rotate(nums: List[int], k: int) -> None:
    n = len(nums)
    k %= n
    
    reverse(nums, 0, n - 1)
    reverse(nums, 0, k - 1)
    reverse(nums, k, n - 1)

# Q2

def isSameTree(p, q):
	if not p and not q:
		return True
	if not p or not q:
		return False
	if p.val != q.val:
		return False
	left = isSameTree(p.left, q.left)
	right = isSameTree(p.right, q.right)

	return left and right

# Q3

from collections import deque
	
def levelOrder(root):
	res = []
	if not root:
		return res
	que = deque([root])
	
	while que:
		level = []
		sz = len(que)
		for _ in range(sz):
			node = que.popleft()
			level.append(node.val)
			if node.left:
				que.append(node.left)
			if node.right:
				que.append(node.right)
		res.append(level)
	return res