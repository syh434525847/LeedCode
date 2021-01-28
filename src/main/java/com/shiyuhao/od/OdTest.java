package com.shiyuhao.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 求字符串出现数字和的最小值，会有负数
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/26 上午9:44
 **/
public class OdTest {
    //字符串格式：a-zA-Z±
    //示例:abc12ss-123b
    //最小值：1+2+（-123）= -120
    //
    //ab0c12ss-123b–1ss+dd–g1g
    //-120
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        char pre = line.charAt(0);
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char cha = line.charAt(i);
            if (cha >= '0' && cha <= '9') {
                int n = Integer.parseInt(String.valueOf(cha));
                if (pre == '-') {
                    int num = 0;
                    while (i < line.length()) {
                        cha = line.charAt(i);
                        if (cha >= '0' && cha <= '9') {
                            num = 10 * num + (cha - '0');
                            i++;
                        } else {
                            sum += (-num);
                            break;
                        }
                    }
                } else {
                    sum += n;
                }
            }
            pre = cha;
        }
        System.out.println(sum);

    }
}
