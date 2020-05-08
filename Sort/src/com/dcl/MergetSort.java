package com.dcl;

import java.util.Arrays;

/**
 * @author dcl
 * @date 2020/5/8 - 20:51
 */
public class MergetSort {
    public static void main(String[] args) {
        int arr[] ={7, 4, 40, 5, 8, 3, 15, 28};

        /*int arr[] = new int[800];
        for (int i = 0; i < 800; i++) {
            arr[i] = (int)(Math.random()*1000);
        }*/
        //long start = System.currentTimeMillis();

        int[] temp = new int[arr.length];
        mergetSort(arr,0,arr.length-1,temp);

        //long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));
        //System.out.println("使用多少时间："+(end-start)+"ms");
    }

    /**
     * 归并排序【分治法】
     *      思想：将一个规模较大，难以解决的问题分解成一个个规模较小，较容易解决的子问题【 先分 】
     *            然后解决每一个子问题，得到每个子问题的解，最后合在一起  【再治(合)】
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergetSort(int[] arr,int left,int right ,int[] temp){
        //递归，每次将数组对半分成两组，对左右两个数组分别排序
        if (left <right){
            //均分数组
            int mid = (right+left)/2;
            //左边数组排序
            mergetSort(arr,left,mid,temp);
            //右边数组排序
            mergetSort(arr,mid+1,right,temp);
            //合
            merget(arr,left,mid,right,temp);
        }

    }

    //合【真正的排序是在合中，借助辅助数组进行合并，由于左边数组和右边数组都是有序的，相当于两个有序表的合并过程】
    public static void merget(int[] arr,int left,int mid,int right,int[] temp){
        //i --> 左边数组起始下标
        int i = left;
        //i --> 右边数组起始下标
        int j = mid+1;
        //辅助数组起始下标
        int t = 0;
        //当左边数组或者右边数组中的元素全部移到辅助数组中之后，结束循环
        while (i <= mid && j <= right){
            //左边数组和右边数组中的元素一一比较，如果较小的元素移入到辅助数组中
            if (arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }

        //如果左边数组右剩余(此时都是排好序的),就将左边数组剩下的元素按顺序移入辅助数组中
        while (i <= mid){
            temp[t++] = arr[i++];
        }

        //如果右边数组右剩余(此时都是排好序的),就将右边数组剩下的元素按顺序移入辅助数组中
        while (j <= right){
            temp[t++] = arr[j++];
        }


        //将辅助数组中的元素复制到arr中
        for (int k =0;k < t;k++){
            arr[left++] = temp[k];
        }
        System.out.println("arr:"+Arrays.toString(arr));

        System.out.println("temp:"+Arrays.toString(temp));
        System.out.println("--------------------");
    }
}
