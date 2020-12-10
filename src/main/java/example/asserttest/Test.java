package example.asserttest;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        list.add("345");
        list.add("453");
        String time;
        for (String lis : list){
            time = "2019/11/28";
            System.out.println(lis+","+time);
        }
    }
}
