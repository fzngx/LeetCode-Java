/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    int m, n;
    boolean validPos(int x, int y, boolean[][] visited) {
        return !(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]);
    }
    private boolean dfs(char[][] board, int x, int y, int idx, String word, boolean visited[][]) {
        if (idx == word.length()) {
            return true;
        }
        if (!validPos(x, y, visited)) return false;
        if (word.charAt(idx) == board[x][y]) {
            visited[x][y] = true;
            if (dfs(board, x + 1, y, idx + 1, word, visited) || dfs(board, x - 1, y, idx + 1, word, visited)
            || dfs (board, x, y + 1, idx + 1, word, visited) || dfs(board, x, y - 1, idx + 1, word, visited)) {
                return true;
            }
            visited[x][y] = false;
            return false;
        }
        return false;

    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
//        Pos.m = m;
//        Pos.n = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];

                    if (dfs(board, i, j, 0, word, visited)) return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

