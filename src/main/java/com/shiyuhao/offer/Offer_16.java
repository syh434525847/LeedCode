package com.shiyuhao.offer;

/**
 * @Description n次方
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/30 3:14 下午
 **/
public class Offer_16 {
    public static void main(String[] args) {
        System.out.println(pow(-0.2, 3));
        System.out.println(10 & 1);
    }
    // TODO
    private static double pow(double base, double exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}

