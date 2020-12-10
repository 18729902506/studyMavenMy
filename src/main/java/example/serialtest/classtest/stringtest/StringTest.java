package example.serialtest.classtest.stringtest;

public class StringTest {

    public static void main(String[] args) {
        String str = "asdfghj";
        //replaceAll()方法，要求第一个参数是正则表达式，符合正则表达式的字符串才会被替换
//        str.replaceAll();
        //123
        System.out.println(str.replace(str,"123"));
    }

}
