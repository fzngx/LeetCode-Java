/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    int countAroundLives(int[][] board, int x, int y) {
        int res = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                i == x && j == y)) {
                    if ((board[i][j]&1) == 1) res++;
                }
            }
        }
        return res;
    }
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int around = countAroundLives(board, i, j);
                if ((board[i][j]) == 1 &&  (around == 2 || around == 3)) {
                    board[i][j] |= 2;
                } else if ((board[i][j]) == 0 && around == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
// @lc code=end

