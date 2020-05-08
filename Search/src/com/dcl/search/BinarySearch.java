package com.dcl.search;

import java.util.ArrayList;

/**
 * @author dcl
 * @date 2020/5/8 - 22:30
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,7,9,9,9,9,912,16,21};
        ArrayList<Integer> integers = binarySearch2(arr, 0, arr.length - 1, 9);
        System.out.println(integers);
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

    /**
     * 优化二分查找：如果数组中有相同的值，把相同的值全部找出，并返回所有值的下标
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findValue){
        //如果没找到，返回空的ArrayList
        if (left > right){
            return new ArrayList<>();
        }
        //二分
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findValue > midVal){
            //向右递归
            return binarySearch2(arr,mid+1,right,findValue);
        }else if(findValue < midVal){
            //向左递归
            return binarySearch2(arr,left,mid,findValue);
        }else {
            //如果找到了，就从当前的位置向左和向右两个方向查找是否右相同的值，然后把所有相同值的下标保存到ArrayLsit中并返回
            ArrayList<Integer> index = new ArrayList<>();

            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findValue){
                    break;
                }
                index.add(temp);
                temp--;
            }

            index.add(mid);

            temp = mid + 1;
            while (true){
                if (temp > right || arr[temp] != findValue){
                    break;
                }
                index.add(temp);
                temp++;
            }

            return index;
        }
    }
}
