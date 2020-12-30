package com.shiyuhao.offer;

import edu.princeton.cs.algs4.In;

/**
 * @Description 回溯算法：矩阵中的路径
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/28 5:09 下午
 **/
public class Offer_12 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };
        System.out.println(exist(board, "bfcl"));

    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1 || word == null) {
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(board, rows, cols, i, j, word, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Description 确定路径的主要方法
     * @Param board 给定的矩阵
     * @Param rows 矩阵行数
     * @Param cols 矩阵列数
     * @Param row 执行到第几行
     * @Param col 执行到第几列
     * @Param word 给定单词
     * @Param pathLength 单词的第几个单词
     * @Param visited 路径是否走过
     * @Return boolean
     * @Author shiyuhao
     * @Date 2020/12/28 5:24 下午
     **/
    private static boolean hasPathCore(char[][] board, int rows, int cols, int row, int col, String word, int pathLength, boolean[][] visited) {
        if (pathLength == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == word.charAt(pathLength) && !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;
            hasPath = hasPathCore(board, rows, cols, row, col - 1, word, pathLength, visited)
                    || hasPathCore(board, rows, cols, row, col + 1, word, pathLength, visited)
                    || hasPathCore(board, rows, cols, row - 1, col, word, pathLength, visited)
                    || hasPathCore(board, rows, cols, row + 1, col, word, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
