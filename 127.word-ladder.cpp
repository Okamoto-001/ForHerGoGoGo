/*
 * @lc app=leetcode id=127 lang=cpp
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (26.78%)
 * Likes:    2283
 * Dislikes: 980
 * Total Accepted:    347.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_map<string, vector<string>>graph(wordList.size());
        deque<string>cur;
        deque<string>next;
        cur.push_back(beginWord);
        int length = 2;
        while (!cur.empty()) {
            string s = cur.front();
            cur.pop_front();
            for (int i = 0; i < wordList.size();) {
                if (transformable(s, wordList[i]))
                    if (wordList[i] == endWord) return length;
                    else graph[s].push_back(wordList[i]), wordList.erase(wordList.begin()+i);
                else i++;
            }
            for (auto x : graph[s]) next.push_back(x);
            if (cur.empty() && !next.empty()) swap(cur, next), length++;
        }
        return 0;
    }

    bool transformable(string s1, string s2) {
        int diff = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] != s2[i]) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
};
// @lc code=end

