package com.dcl;

import java.util.Arrays;

/**
 * @author dcl
 * @date 2020/5/7 - 22:56
 */
public class ShellSort {
    public static void main(String[] args) {
        //int arr[] = {7, 4, 40, 5, 8, 3, 15, 28, 39, 23,11};

        int arr[] = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random()*1000000000);
        }
        long start = System.currentTimeMillis();
        shellSort(arr);
        long end = System.currentTimeMillis();
        shellSort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println("使用多少时间："+(end-start)+"ms");
    }

    //希尔排序[插入排序的改进]-->缩小增量排序
    public static void shellSort(int[] arr) {
        //逐次缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //常规插入排序，跳跃式插入，按照增量分组，在组内排序;
            for (int i = gap; i < arr.length; i++) {
                int index = i - gap;
                int tmp = arr[i];
                while (index >= 0 && tmp < arr[index]) {
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                if (index != i - gap) {
                    arr[index + gap] = tmp;
                }
            }
        }
    }

}
