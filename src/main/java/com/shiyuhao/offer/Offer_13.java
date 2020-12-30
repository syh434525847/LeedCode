package com.shiyuhao.offer;

/**
 * @Description 机器人的运动范围
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/29 10:28 上午
 **/
public class Offer_13 {
    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCountCore(m, n, k, 0, 0, visited);
    }

    public static int movingCountCore(int m, int n, int k, int row, int col, boolean[][] visited) {
        int count = 0;
        if (checkNum(m, n, k, row, col, k, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(m, n, k, row - 1, col, visited)
                    + movingCountCore(m, n, k, row, col - 1, visited)
                    + movingCountCore(m, n, k, row + 1, col, visited)
                    + movingCountCore(m, n, k, row, col + 1, visited);
        }
        return count;
    }

    private static boolean checkNum(int m, int n, int k, int row, int col, int k1, boolean[][] visited) {
        if (row >= 0 && row < m && col >= 0 && col < n && getNum(row) + getNum(col) <= k && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private static int getNum(int row) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        return sum;
    }
}
