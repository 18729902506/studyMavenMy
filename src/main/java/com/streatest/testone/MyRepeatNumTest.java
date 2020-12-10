package com.streatest.testone;

import org.junit.Test;
import java.util.*;

/***
 * @author shang
 * @date 2020-09-17
 * java判断数组中是否有重复的元素：最初想法：放到set集合中，看set集合的长度是否和数组的长度相等
 */
public class MyRepeatNumTest {

    /**
     * 假设数组中没有重复的数字，即1-N每个数字出现一次，那么该数组的和一定为N*(N+1)/2，如果和不是，就说明出现了重复的数字，
     * 所以只要遍历一遍数组，求数组的和即可。
     * 此方法不是那么的准确，如果数组是[2, 2, 2]，并没有满足
     * */
    static boolean isRepeatNum(int[] a) {
        int sum = 0;
        int n = a.length;
        for (int i : a) {
            sum += i;
        }
        if (sum == n * (n + 1) / 2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {2, 2, 3, 3, 6};
        System.out.println("数组array1中是否出现了重复数字：" + isRepeatNum(array1));
        System.out.println("数组array2中是否出现了重复数字：" + isRepeatNum(array2));
    }


    /**判断list中是否有重复的元素，可以使用HashSet，HashSet<T>含不重复项的无序列表，HashSet可以自动去除重复项*/
    @Test
    public void testLIstSameOrNot(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(2);
        //set集合的长度是3    可以打印出：list中存在重复的数据
        HashSet<Integer> hashSet = new HashSet<>(list);
        if (list.size() != hashSet.size()) {
            System.out.println("list中存在重复的数据");
        }
    }

    /**list的contains()方法可以判断list中是否包含某一个元素*/
    @Test
    public void testContains() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(2);
        List<Integer> list2 = new ArrayList<>();
        for (Integer integer : list) {
            if (list2.contains(integer)) {
                System.out.println("list中存在重复的数据");
            }
            list2.add(integer);
        }
    }
}