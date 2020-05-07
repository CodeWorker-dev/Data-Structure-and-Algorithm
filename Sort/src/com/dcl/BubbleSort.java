package com.dcl;

import java.util.Arrays;

/**
 * @author dcl
 * @date 2020/5/7 - 14:11
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int arr[] = {3,4,40,5,8,7,15,28,39};
        int arr[] = new int[88888];
        for (int i = 0; i < 88888; i++) {
            arr[i] = (int)(Math.random()*800000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));

        System.out.println("使用多少时间："+(end-start)+"ms");
    }

    /**
     * 冒泡排序--时间复杂度 O(n²)
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        //计次
        int count=0;
        //直接跳出标志位，每开启一轮排序，flag为true。每轮排序结束进行判断，如果没发生交换，就说明整个数组已经排好序，直接跳出即可;
        boolean flag;
        int temp;
        for (int i = 0;i<arr.length-1;i++){
            //每轮排序，flag置为true
            flag = true;
            for (int j=0;j < arr.length-1-i;j++){
                //交换
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //如果发生交换，flag置为false
                    flag = false;
                }
            }
            //该轮中没发生交换，直接跳出循环
            if (flag){
                break;
            }
            count++;
        }
        System.out.println(count+"次");
    }
}
