/*
 * @lc app=leetcode id=207 lang=cpp
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (40.20%)
 * Likes:    2693
 * Dislikes: 140
 * Total Accepted:    309K
 * Total Submissions: 762.6K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, int> d;
        queue<int> que;
        unordered_map<int, vector<int>> g;
        for (auto &edge : prerequisites) {
            int a = edge.first, b = edge.second;
            d[b] ++;
            if (!d.count(a)) d[a] = 0;
            if (!g.count(a)) g[a] = vector<int> ();
            g[a].push_back(b);
        }

        for (auto &node : d) {
            if (!node.second) que.push(node.first);
        }
        while (!que.empty()) {
            int t = que.front();
            que.pop();
            for (int e : g[t])
                if (--d[e] == 0)
                    que.push(e);
        }
        for (auto &node : d)
            if (node.second)
                return false;
        return true;
    }
};
// @lc code=end

