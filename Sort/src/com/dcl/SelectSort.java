package com.dcl;

import java.util.Arrays;

/**
 * @author dcl
 * @date 2020/5/7 - 15:14
 */
public class SelectSort {
    public static void main(String[] args) {
        //int arr[] = {101,34,119,1,109,33,27,18};
        int arr[] = new int[88888];
        for (int i = 0; i < 88888; i++) {
            arr[i] = (int)(Math.random()*800000);
        }

        long start =System.currentTimeMillis();
        selectSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));

        System.out.println("使用多少时间："+(end-start)+"ms");
    }

    /**
     * 选择排序 时间复杂度 O(n²)
     * @param arr
     */
    public static void selectSort(int[] arr){
        //需要进行 n-1 轮次选择
        for (int i = 0;i<arr.length-1;i++){
            //假设当前轮次的第一个数是最小的  K记录下标  min表示最小的值;
            int k = i;
            int min = arr[i];
            //与arr[i]后面的值一一比较，每次选择出较小的那个值
            for (int j = i+1;j<arr.length;j++){
                if (min > arr[j] ){
                    min = arr[j];
                    k = j;
                }
            }
            //把选择出的最小值与该轮次首位进行互换
            if (k != i){
                arr[k] = arr[i];
                arr[i] = min;
            }
        }
    }
}
