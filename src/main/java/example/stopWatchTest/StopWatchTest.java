package example.stopWatchTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 例子1执行耗时：103
 * 例子2执行耗时：203
 */
public class StopWatchTest {

    public static void test() throws InterruptedException{

        long start  = System.currentTimeMillis();
        List<String> list1 = new ArrayList<>();
        list1.add("尚11103262|4567");
        list1.add("沈11103665|6789");
        list1.add("覃11109857|5678");
        for (String list : list1){
            list.toLowerCase().substring(0,6).split("|");
        }
        Thread.sleep(100);
        long end = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        List<String> list2 = new ArrayList<>();
        list2.add("周1116543|5432");
        list2.add("王1115434|2432");
        list2.add("程1116544|7657");
        for (String list : list2){
            Arrays.stream(list.split("|"));
        }
        Thread.sleep(200);
        long end2 = System.currentTimeMillis();

        System.out.println("例子1执行耗时：" + (end - start));
        System.out.println("例子2执行耗时：" + (end2 - start2));
    }
}
