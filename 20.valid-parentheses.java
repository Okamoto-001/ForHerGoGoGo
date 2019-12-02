/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.52%)
 * Likes:    3647
 * Dislikes: 176
 * Total Accepted:    762.4K
 * Total Submissions: 2M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        return forWard(s, 0) == -1;
    }

    public int forWard(String s, int i) {
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ')' || c == '}' || c == ']')
                return i;

            
            i = forWard(s, i+1);

            //for one element
            if (i <= 0)
                return 0;
            char c2 = s.charAt(i);

            if ((c == '(' && c2 != ')') || 
                (c == '{' && c2 != '}') ||
                (c == '[' && c2 != ']'))
                return 0;
            i++;
        }
        //have to return -1 for 
        // one element and valid parentheses
        return -1;
    }
}
// @lc code=end

