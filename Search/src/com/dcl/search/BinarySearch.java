package com.dcl.search;

/**
 * @author dcl
 * @date 2020/5/8 - 22:30
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,12,16,21};
        int i = binarySearch(arr, 0, arr.length - 1, 123);
        System.out.println(i);
    }

    /**
     * 二分查找
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static int binarySearch(int[] arr,int left,int right,int findValue){
        //出口1
        if (left > right){
            return -1;
        }
        //二分
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findValue > midVal){
            //向右递归
            return binarySearch(arr,mid+1,right,findValue);
        }else if(findValue < midVal){
            //向左递归
            return binarySearch(arr,left,mid,findValue);
        }else {
            //如果找到了，就返回该值的下标
            return mid;
        }
    }
}
