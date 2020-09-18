import java.util.Queue;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    /*
    // DFS
    public static boolean dfs(String s, int index, List<String> wordList, boolean[] visited) {
        for (String word: wordList) {
            int nextIndex = index + word.length();
            if (nextIndex <= s.length() && visited[nextIndex] == false) {
                if (s.indexOf(word, index) == index) {
                    if (nextIndex == s.length() || dfs(s, nextIndex, wordList, visited)) {
                        return true;
                    }
                    visited[index] = true;
                    
                }
        
            }
        }
        return false;
    }
    public static boolean wordBreak(String s, List<String> wordList) {
        wordList.sort((o1, o2) -> o2.length() - o1.length());
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(s, 0, wordList, visited);
    } */

    // BFS
    public boolean wordBreak(String s, List<String> wordList) {
        Queue<Integer> nextIndex = new LinkedList<>();
        boolean[] inQ = new boolean[s.length() + 1];
        nextIndex.offer(0);
        
        while (!nextIndex.isEmpty()) {
            int index = nextIndex.poll();
        
            
            for (String word: wordList) {
                if (s.indexOf(word, index) == index) {
                    int next = index + word.length();
                    if (next == s.length()) return true;
                    if (next < s.length() && inQ[next] == false) {
                        nextIndex.offer(next);
                        inQ[next] = true;
                    }
                }
            }
        }
        return false;
    }
}
// @lc code=end

