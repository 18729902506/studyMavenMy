package com.colltest.colltest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/***
 * @author shang
 * @date 2019/09/07
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("4");
        list.add("1");
        list.add("2");
        //[3,4,1,2]
        System.out.println(list);
        //排序前--[3,4,1,2]
        System.out.println("排序前--"+list.toString());
        for (String li:list) {
            //3 4 1 2
            System.out.print(li+" ");
        }
        System.out.println("");
        Collections.sort(list);
        //排序后--[1,2,3,4]
        System.out.println("排序后--"+list.toString());
        for (String li2:list) {
            //1 2 3 4
            System.out.print(li2+" ");
        }

        TestA testA1 = new TestA("张璋",3);
        TestA testA2 = new TestA("李莉",1);
        TestA testA3 = new TestA("王魍",2);
        List<TestA> list1 = new ArrayList<>();
        list1.add(testA1);
        list1.add(testA2);
        list1.add(testA3);
        System.out.println("排序前"+list1.toString());

//        Collections.sort(list1, new Comparator<TestA>() {
//            @Override
//            public int compare(TestA o1, TestA o2) {
//                return o1.getId().compareTo(o2.getId());
//            }
//        });

        Collections.sort(list1,Comparator.comparing(TestA::getId));
//        Collections.sort(list1, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        System.out.println("升序排序后"+list1.toString());
    }
}
