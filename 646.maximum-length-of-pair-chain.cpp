/*
 * @lc app=leetcode id=646 lang=cpp
 *
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximu·m-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (50.20%)
 * Likes:    671
 * Dislikes: 59
 * Total Accepted:    45.1K
 * Total Submissions: 89.9K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * 
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion. 
 * 
 * 
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(), pairs.end(), [](vector<int>& a, vector<int>& b){
            return a[1] < b[1];
        });

        vector<int> dp(pairs.size(), 1);
        for (int i = 1; i < pairs.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = max(dp[i], dp[j]+1);
                }
            }
        }
        return dp.back();


        // stack<vector<int>> stack;

        // sort(pairs.begin(), pairs.end(), [](vector<int>& a, vector<int>& b) {
        //     return a[1] < b[1];
        // });

        // for (auto pair: pairs) {
        //     if (stack.empty()) stack.push(pair);

        //     if (pair[0] > (stack.top()[1]) ) stack.push(pair);
        // }
        // return stack.size();

    }
};
// @lc code=end

