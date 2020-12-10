package example.stopWatchTest;

import org.springframework.util.StopWatch;

import java.util.*;

/***
 * stopWatch.prettyPrint():-----------------
 * StopWatch 'test': running time (millis) = 136
 * -----------------------------------------
 * ms     %     Task name
 * -----------------------------------------
 * 00052  038%  task1
 * 00084  062%  task2
 * 一个StopWatch实例一次只能开启一个任务，不能同时开启多个任务，
 * 并且在该任务未stop之前不能start一个新的任务，
 * 要开启一个新的任务，就必须stop上个任务，若要一次开启多个任务，需要new不同的StopWatch实例
 *
 * 可在调用start()方法时，直接指明任务的名字，从而更直观的显示出来。
 * 但是可以使用reset()方式，然后再开启一个任务。stopWatch.reset().start()
 */
public class StopWatchTest2 {

    public static void test2()throws InterruptedException{
        StopWatch stopWatch = new StopWatch("test");
        stopWatch.start("task1");
        Set<String> set = new HashSet<>();
        set.add("尚11103262|4567");
        set.add("沈11103665|6789");
        set.add("覃11109857|5678");
        for (String list : set){
            list.toLowerCase();
        }
        Thread.sleep(50);
        stopWatch.stop();

        stopWatch.start("task2");
        List<String> list2 = new ArrayList<>();
        list2.add("周1116543|5432");
        list2.add("程1116544|7657");
        list2.add("王1115434|2432");
        for (String list : list2){
            Arrays.stream(list.split("|"));
        }
        Thread.sleep(80);
        stopWatch.stop();
        System.out.println("stopWatch.prettyPrint():-----------------");
        System.out.println(stopWatch.prettyPrint());

    }
}
