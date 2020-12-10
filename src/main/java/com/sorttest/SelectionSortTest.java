package com.sorttest;

import java.util.Arrays;

/***
 * @author shang
 * @date 2019/09/08
 * 选择排序，在未排序列中找到最小的元素，存放到排序序列的起始位置，
 * 然后在未排序的元素中继续寻找最小的元素，放到已排序的末尾
 */
public class SelectionSortTest {
    public static void main(String[] args) {
        selectionSort();
    }

    public static void selectionSort(){
        int[] array = {3,7,2,9,4,6};
        for (int i = 0;i<array.length;i++){
            //minIndex是临时最小的索引，也是未排序的第一个数字
            int minIndex = i;
            for (int j = i+1;j<array.length;j++){
                //找到最小的数
                if (array[j]<array[minIndex]){
                    //将最小数的索引保存
                    minIndex = j;
                }
            }
            //交换
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
