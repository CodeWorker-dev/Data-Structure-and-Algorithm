package com.dcl.search;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author dcl
 * @date 2020/5/9 - 0:22
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));

        int i = insertSearch(arr, 0, arr.length - 1, 77);
        System.out.println(i);
    }

    /**
     * 插值查找：在二分查找的基础上，修改了求mid值的公式
     *          对于大数据量较大，关键字分布比较均匀的情况下，使用插值查找，速度较快
     *          在关键字分布不均匀的情况下，插值查找可能不如二分查找
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static int insertSearch(int[] arr,int left,int right,int findValue){
        if (left > right || findValue < arr[0] || findValue > arr[arr.length-1]){
            return -1;
        }
        System.out.println("查找~~");
        int mid = left + (right - left)*(findValue - arr[left])/(arr[right] - arr[left]);
        int midValue = arr[mid];
        if (findValue > midValue){
            //向右递归
            return insertSearch(arr,mid+1,right,findValue);

        }else if (findValue < midValue){
            //向左递归
            return insertSearch(arr,left,mid,findValue);
        }else {
            //找到返回
            return mid;
        }
    }
}
