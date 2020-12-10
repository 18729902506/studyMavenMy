package com.sorttest;

import java.util.Arrays;

/***
 * @author shang
 * @date 2019/09/08
 * 冒泡排序，两两比较，如果前面的比后面的大，就交换
 * 从小到大排序
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        bubbleSort();
    }

        public static void bubbleSort() {
            int[] array = {2,0,5,8,1};
               //外层：需要length-1次循环比较
                for (int i = 0; i < array.length-1; i++) {
                    //内层：每次循环需要两两比较的次数，每次比较后，都会将当前最大的数放到最后位置，所以每次比较次数递减一次
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        if (array[j] > array[j+1]) {
                            int temp = array[j];
                            array[j] = array[j+1];
                            array[j+1] = temp;
                        }
                    }
                }
        System.out.println(Arrays.toString(array)+"&&&&&&&&&&&&");
    }



}
