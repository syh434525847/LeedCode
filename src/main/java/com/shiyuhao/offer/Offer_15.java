package com.shiyuhao.offer;

/**
 * @Description 位运算，判断有多少个1
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/30 2:35 下午
 **/
public class Offer_15 {

    public static void main(String[] args) {
        System.out.println(numberOf1(15));
        System.out.println(numberOf2(15));
    }

    private static int numberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    private static int numberOf2(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            n = n & (n - 1);
        }
        return count;
    }

}
