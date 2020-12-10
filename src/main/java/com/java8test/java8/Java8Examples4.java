package com.java8test.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/***
 * @author
 * @date 2019/10/20
 * 将lambda表达式付诸实践，环绕执行模式
 */
public class Java8Examples4 {

    public static String processFile() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            //做有用工具的那行代码，只能读文件的第一行
            return br.readLine();
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader b)throws IOException;
    }

    /***
     * 执行一个行为
     * @param p
     * @return
     * @throws IOException
     */
    public static String processFile(BufferedReaderProcessor p)throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            //处理BufferedReader对象
            return p.process(br);
        }
    }

    public static void main(String[] args)throws IOException {
        //通过传递不同的lambda表达式来重用processFile()方法
        String oneLine = processFile((BufferedReader br) -> br.readLine());
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }

}
