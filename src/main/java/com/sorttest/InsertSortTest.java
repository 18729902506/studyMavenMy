package com.sorttest;

import java.util.Arrays;

/***
 * @author shang
 * @date 2019/09/08
 * 插入排序
 * 从第一个元素开始，该元素已经默认排好序了，取下一个元素，在已经排好序的元素中从后往前扫描，
 * 如果已经排序的元素大于新元素，就交换
 */
public class InsertSortTest {
    public static void main(String[] args) {
        insertSort();
    }

    public static void insertSort(){
        int[] array = {3,6,5,1,9,2};
        for (int i = 1;i<array.length;i++){
            //刚开始时，temp是从第二个数开始
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            array[j] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
