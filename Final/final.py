from collections import defaultdict


# Time complexity is O(nk) where n is # of strings, and k is the maximum length
# of the string in the list.
# Space complexity is O(nk) since we need to store all strings.
def Q1(strs):
    res = defaultdict(list)

    for s in strs:
        count = [0] * 26
        for c in s:
            count[ord(c) - ord("a")] += 1
        res[tuple(count)].append(s)

    return res.values()


# Time complexity is O(mn) where m is # of rows and n is # of columns, since we
# need to go over every grid anyway.
# Space complexity is O(mn) as well since worst case the map can be filled with
# all lands and our recursion stack will be that deep.
def Q2(grid):
    island = 0
    dir = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    R = len(grid)
    C = len(grid[0])

    def dfs(i, j):
        if grid[i][j] == "0":
            return
        grid[i][j] = "0"
        for d in dir:
            ni, nj = i + d[0], j + d[1]
            if ni >= 0 and ni < R and nj >= 0 and nj < C and grid[ni][nj] == "1":
                dfs(ni, nj)

    res = 0

    for i in range(R):
        for j in range(C):
            if grid[i][j] == "1":
                res += 1
                dfs(i, j)

    return res


# Time complexity is O(n) since we need to linearly scan the string.
# Space complexity is O(n) since worst case the string can all be ( or ) and
# they will all be in the stack.
def Q3(s):
    # Change to list since string in Python is immutable.
    ls = list(s)
    stack = []

    for i, char in enumerate(ls):
        if char == "(":
            stack.append(i)
        elif char == ")":
            if stack:
                # if there is ( to match
                stack.pop()
            else:
                # otherwise the ) needs to go
                ls[i] = ""

    # Remove all remaining unmatched (
    while stack:
        ls[stack.pop()] = ""

    return "".join(ls)


# Time complexity is O(mn) where m is # of rows and n is # of columns, since we
# need to go over every grid.
# Space complexity is O(mn) since we use another dp array to do the computation.
# It could be further compressed by reusing dp[i-1] every time but we wont detail
# that for time's sake. Further, if we want to be really saving space, we can
# modify obstacleGrid in place and that _could_ be considered O(1) if you want.
def Q4(obstacleGrid):
    m = len(obstacleGrid)
    n = len(obstacleGrid[0])
    dp = [[0] * n for _ in range(m)]

    for i in range(m):
        if obstacleGrid[i][0] == 1:
            dp[i][0] = 0
            continue
        if i == 0:
            dp[i][0] = 1
            continue
        dp[i][0] = 0 if dp[i - 1][0] == 0 else 1

    for j in range(n):
        if obstacleGrid[0][j] == 1:
            dp[0][j] = 0
            continue
        if j == 0:
            dp[0][j] = 1
            continue
        dp[0][j] = 0 if dp[0][j - 1] == 0 else 1

    for i in range(1, m):
        for j in range(1, n):
            if obstacleGrid[i][j] == 1:
                dp[i][j] = 0
                continue
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

    return dp[-1][-1]


def q1Test():
    print(Q1(["eat", "tea", "tan", "ate", "nat", "bat"]))
    print(Q1([""]))
    print(Q1(["a"]))
    print("")


def q2Test():
    print(Q2([
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"]
    ]))
    print(Q2([
        ["1", "1", "0", "0", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "1", "0", "0"],
        ["0", "0", "0", "1", "1"]
    ]))
    print("")


def q3Test():
    print(Q3("lee(t(c)o)de)"))
    print(Q3("a)b(c)d"))
    print(Q3("))(("))


def q4Test():
    print(Q4([[0, 0, 0], [0, 1, 0], [0, 0, 0]]))
    print(Q4([[0, 1], [0, 0]]))


if __name__ == "__main__":
    q1Test()
    q2Test()
    q3Test()
    q4Test()
