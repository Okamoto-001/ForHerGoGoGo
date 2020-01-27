#
# @lc app=leetcode id=155 lang=python3
#
# [155] Min Stack
#
# https://leetcode.com/problems/min-stack/description/
#
# algorithms
# Easy (39.55%)
# Likes:    2260
# Dislikes: 244
# Total Accepted:    369.3K
# Total Submissions: 933.8K
# Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
#
# Design a stack that supports push, pop, top, and retrieving the minimum
# element in constant time.
# 
# 
# push(x) -- Push element x onto stack.
# pop() -- Removes the element on top of the stack.
# top() -- Get the top element.
# getMin() -- Retrieve the minimum element in the stack.
# 
# 
# 
# 
# Example:
# 
# 
# MinStack minStack = new MinStack();
# minStack.push(-2);
# minStack.push(0);
# minStack.push(-3);
# minStack.getMin();   --> Returns -3.
# minStack.pop();
# minStack.top();      --> Returns 0.
# minStack.getMin();   --> Returns -2.
# 
# 
# 
# 
#

# @lc code=start
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []


    def push(self, x: int) -> None:
        if not self.stack:self.stack.append((x, x))
        else :
            self.stack.append((x, min(x, self.stack[-1][1])))

    def pop(self) -> None:
        if self.stack: self.stack.pop()
#         return second element from the last in the tuple which is the min val
# eg :
# push 1
# push 2
# push 5
# the stack will look like:
# (5,1)
# (2,1)
# (1,1)

# return stack[-1] -> (5,1)
# return stack[-1][1] -> 1
    def top(self) -> int:
        if self.stack: return self.stack[-1][0]
        else : return None

    def getMin(self) -> int:
        if self.stack: return self.stack[-1][1]
        else : return None


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# @lc code=end

