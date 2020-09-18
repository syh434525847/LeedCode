package com.shiyuhao.leetcode;

import java.util.*;

/**
 * @Description 区间合并
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/24 2:20 下午
 **/
public class Merge {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 6}, {15, 18}, {8, 10}};
        merge(a);
    }

    public static int[][] merge(int[][] a) {
        Arrays.sort(a, (x, y) -> {
            if (x[0] < y[0]) {
                return -1;
            } else if (x[0] > y[0]) {
                return 1;
            } else {
                return 0;
            }
        });
        List<List<Integer>> result = new LinkedList<>();
        result.add(Arrays.asList(a[0][0], a[0][1]));
        for (int i = 1; i < a.length; i++) {
            int[] curr = a[i];
            List<Integer> last = result.get(result.size() - 1);
            if (curr[0] <= last.get(1)) {
            }
        }

        System.out.println(a);
        return null;
    }
}
