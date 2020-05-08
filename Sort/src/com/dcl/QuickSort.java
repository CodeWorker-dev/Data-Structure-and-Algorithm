package com.dcl;

import java.util.Arrays;

/**
 * @author dcl
 * @date 2020/5/8 - 16:40
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3,4,40,5,8,7,15,28,39};
//        int arr[] = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int)(Math.random()*1000000000);
//        }
//        long start = System.currentTimeMillis();

        quickSort(arr,0,arr.length-1);

//        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));

//        System.out.println("使用多少时间："+(end-start)+"ms");
    }

    /**
     * 快速排序（基准排序->升级版冒泡排序）
     * 基本思想：以数组最左边的元素为基准值，然后定义两个指针，分别指向最左边和最右边
     *          先从右边往左边扫描（指针移动），如果扫描到的值小于基准值，就停止
     *          再从左边往右边扫描（指针移动），如果扫描到的值大于基准值，就停止
     *              然后两个指针所指向值互换位置，继续扫描
     *              【先让右往左扫描，在让左往右扫描，这个顺序可以保证当两个指针相遇停下的时候，所指向的值一定的小于或等于基准值的】
     *              然后将最左边的位置(基准值)与指针停下来的位置进行互换
     *              最后递归调用快速排序（先排左边，再排右边）
     *
     * 核心思想：每一轮快速排序都以基准值为中心，然后把比基准值小的放在左边，把基准值大的放在右边，然后递归调用
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left,int right){
        //递归出口
        if (left >= right){
            return;
        }
        //基准值为最左边的值（可以任意）
        int base = arr[left];
        //左边指针
        int i = left;
        //右边指针
        int j = right;
        //两边指针重合时，一轮排序就结局了
        while (i != j){
            //当右边扫描到的值小于基准值时，跳出循环。【如果一直没有扫描到，则当 i=j 时跳出循环】
            while (arr[j] >= base && i < j){
                j--;
            }
            //当左边扫描到的值大于基准值时，跳出循环。【如果一直没有扫描到，则当 i=j 时跳出循环】
            while (arr[i] <= base && i < j){
                i++;
            }

            //两值互换
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }

        //基准位置与重合位置互换
        arr[left] = arr[i];
        arr[i] = base;

        //左边快排
        quickSort(arr,left,i-1);

        //右边快排
        quickSort(arr,j+1,right);


    }
}

