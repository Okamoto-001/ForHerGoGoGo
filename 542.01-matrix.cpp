/*
 * @lc app=leetcode id=542 lang=cpp
 *
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (37.78%)
 * Likes:    987
 * Dislikes: 93
 * Total Accepted:    64.8K
 * Total Submissions: 170.5K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * 
 * 
 * Example 1: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[0,0,0]]
 * 
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * 
 * 
 * Example 2: 
 * 
 * 
 * Input:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,1,1]]
 * 
 * Output:
 * [[0,0,0],
 * ⁠[0,1,0],
 * ⁠[1,2,1]]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        int n = matrix.size(), m = matrix[0].size();

// default is 0, for if (x >= 0....) set it as -1
        vector<vector<int>> dist(n, vector<int> (m, -1));
        queue<pair<int, int>> q;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!matrix[i][j]) {
                    dist[i][j] = 0;
                    q.push(make_pair(i, j));
                }
            }
        }

        int dx[4] ={-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

        while (q.size()) {
            auto t = q.front();
            q.pop();
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + t.first, y = dy[i] + t.second;

                if (x >= 0 && x < n && y >= 0 && y < m && dist[x][y] == -1) {
                    dist[x][y] = dist[t.first][t.second] + 1;
                    q.push(make_pair(x, y));
                }
            }
        }
        return dist;

    }
};
// @lc code=end

