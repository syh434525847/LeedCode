package com.shiyuhao.od;

import java.util.Scanner;

/**
 * @Description 求坐标轴上画出图形的面积
 * 从(0,0)开始，指定终点x坐标，y轴坐标以偏移量呈现，-表示向下偏移
 * 第1行：n e ，n表示有几组数据，e表示终点坐标
 * 第2-n行：x offsety 每次x都会递增
 *
 * 比如：
 * 3 8
 * 0 1
 * 2 1
 * 4 -4
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/26 上午10:15
 **/
public class OdTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count = Integer.parseInt(line.split(" ")[0]);
        int end = Integer.parseInt(line.split(" ")[1]);
        int preX = 0;
        int preY = 0;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            String xyLine = scanner.nextLine();
            int xOffset = Integer.parseInt(xyLine.split(" ")[0]);
            int yOffset = Integer.parseInt(xyLine.split(" ")[1]);
            if (preY < 0) {
                preY = Math.abs(preY);
            }
            int mj = preY * (xOffset - preX);

            preY = preY + yOffset;
            preX = xOffset;
            sum += mj;
        }
        if (preY < 0) {
            preY = Math.abs(preY);
        }
        sum = sum + (end - preX) * preY;
        System.out.println(sum);
    }
}
