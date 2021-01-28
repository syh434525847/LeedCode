package com.shiyuhao.test;

import java.util.*;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/25 下午5:11
 **/
public class MetrxTest {
    private static int N, M;
    private static int[][] map;
    public static void main(String[] args) {
        N = 5;
        M = 5;
        map = new int[N][M];
        int[][] mg = new int[N][M];
        dfs(0, 0);
        sout(0, 0);
        Map<Character, Integer> map = new HashMap<>();

    }

    private static void dfs(int x, int y) {
        if (x == N-1 && y == M - 1) {
            return;
        }
        if(x + 1 < N) {
            if (map[x + 1][y] != 1) {
                dfs(x + 1, y);
            }
        }
        if(y + 1 < M) {
            if (map[x][y + 1] != 1) {
                dfs(x, y + 1);
            }
        }
        if (x + 1 == N && map[x][y+1] == 1) {
            map[x][y] = 1;
        }
        if (x + 1 != N && y+1 != M) {
            if(map[x+1][y] == 1 && map[x][y+1]==1 ) {
                map[x][y] = 1;
            }
        }
    }

    private static void sout(int x,int y) {
        if (x == N - 1&& y == M - 1) {
            System.out.println("(" + x + "," + y + ")");
            return;
        }
        if(x + 1 < N) {
            if (map[x + 1][y] != 1) {
                System.out.println("(" + x + "," + y + ")");
                sout(x + 1, y);
            }
        }
        if(y + 1 < M) {
            if (map[x][y + 1] != 1) {
                System.out.println("(" + x + "," + y + ")");
                sout(x, y + 1);
            }
        }
    }
}
