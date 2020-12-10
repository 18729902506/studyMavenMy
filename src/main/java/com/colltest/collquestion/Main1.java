package com.colltest.collquestion;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/***
 * 一个程序，将输入的字符串中的字符按照如下的规则排序
 * 1、英文字母从A到Z排序，不区分大小写
 * 2、同一个英文字母的大小写同时存在时，按照输入的顺序排列
 * 3、非英文字母的其他字符保持原来的位置
 * @author shang
 * @date 2019/09/07
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String string = in.nextLine();
            LinkedList<String> list = new LinkedList<>();
            char[] cs = string.toCharArray();
            boolean flag = true;
            for (int i = 0;i<cs.length;i++){
                 flag = (cs[i]>='a' && cs[i]<='z') || (cs[i]>='A' && cs[i]<='Z');
                if (flag) {
                    list.add(String.valueOf(cs[i]));
                }
            }
            //字符串忽略大小写排序
            Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
            System.out.println(list);
            for (int i = 0,j = 0;i<cs.length;i++){
                boolean flag2 = true;
                if (flag2){
                    //如果是字母，就根据索引得到集合中元素
                    System.out.print(list.get(j));
                    j++;
                }else{
                    //非英文字母的其他字符保持原来的位置
                    System.out.print(cs[i]);
                }
            }
            System.out.println();
        }
    }
}
