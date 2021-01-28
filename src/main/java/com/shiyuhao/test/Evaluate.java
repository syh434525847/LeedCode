package com.shiyuhao.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/20 下午1:54
 **/
public class Evaluate {
    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        Scanner scanner = new Scanner(System.in);

        String input = "";
        while(scanner.hasNextLine()){
            input = scanner.nextLine(); // 输入按照空格隔开
            System.out.println(String.format("===%s===",input));

            if( null == input || input.equals("")){ //退出
                break;
            }
            if(input.equalsIgnoreCase("q")) break; //退出


            String[] sList = input.split(" ");

            for(String s : sList){
                if(s.equals("(")){
                    ops.push(String.valueOf(s));
                }else if(s.equals("+") || s.equals("-")) {
                    if(!ops.empty()){
                        String lastOp = ops.peek();
                        if(lastOp.equals("*") || lastOp.equals("/") || lastOp.equals("sqrt")){
                            double v = vals.pop();
                            String op = ops.pop();
                            if(op.equals("*")) v = vals.pop() * v;
                            else if(op.equals("/")) v = vals.pop() / v;
                            else if(op.equals("sqrt")) v = Math.sqrt(v);

                        }
                    }

                    ops.push(String.valueOf(s));
                }else if( s.equals("*") || s.equals("/") || s.equals("sqrt")){
                    ops.push(String.valueOf(s));
                }else if(s.equals(")")){//如果字符为'）'，进行弹出操作，计算结果并压入栈

                    while(!ops.empty() && !ops.peek().equals("(")){
                        String op = ops.pop();
                        double v = vals.pop();

                        if(op.equals("+")) v = vals.pop() + v;
                        else if(op.equals("-")) v = vals.pop() - v;
                        else if(op.equals("*")) v = vals.pop() * v;
                        else if(op.equals("/")) v = vals.pop() / v;
                        else if(op.equals("sqrt")) v = Math.sqrt(v);
                        vals.push(v);

                    }

                    if(!ops.empty() && ops.peek().equals("(")){
                        ops.pop();
                    }

                    if(!ops.empty() && ops.peek().equals("sqrt")){
                        ops.pop();

                        double v = vals.pop();
                        v = Math.sqrt(v);
                        vals.push(v);
                    }

                }else { //如果字符既非运算符也不是括号，将它作为double值压入栈
                    vals.push(Double.valueOf(s));
                }
            }
            System.out.println(vals.pop());
        }

        System.out.println(String.format("===you quit !==="));

    }
}
