package com.dcl;

import java.util.Arrays;

/**
 * @author dcl
 * @date 2020/5/7 - 16:14
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = {3,-1,6,4,10};
        int arr[] = new int[88888];
        for (int i = 0; i < 88888; i++) {
            arr[i] = (int)(Math.random()*800000);
        }
        long start = System.currentTimeMillis();
        insertSort(arr);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(arr));

        System.out.println("使用多少时间："+(end-start)+"ms");
    }

    /**
     * 插入排序  时间复杂度 O(n²)
     *
     * 将第一个元素看成有序列表 ，第二到最后一个元素看成无序列表
     *     每次取无序列表中最左边的元素向有序列表中插入，由右向左跟有序列表中的每一个元素比较，
     *     如果大于比较的元素，就停止比较，此时index所记录的位置就是应该插入的位置
     *     如果小于比较的元素，就将有序列表中的元素右移，index指针左移，现在index指向的位置既是可能插入的位置
     *     如果一直比到arr[0],还是比arr[0]小，此时就不用再比了【所以while的条件有index>0】
     * @param arr
     */
    public static void insertSort(int[] arr){
        //tmp -> 记录当前元素
        int tmp;
        //index -> 标记插入的位置
        int index;
        //将第一个元素看成有序列表，其他元素看成无序列表，无序列表逐个插入到有序列表中
        for(int i = 1;i < arr.length;i++){
            tmp = arr[i];
            index = i-1;
            //index只是记录位置，tmp表示的时当前需要往有序列表中插入的元素
            while(index >= 0 && tmp < arr[index]){
                arr[index+1] = arr[index];
                index -- ;
            }
            //当需要插入的位置和当前位置不一样的时候，就可以插入元素。如果一样，说明目前就是有序的。
            if (index != i){
                arr[index+1] = tmp;
            }
        }
    }
}
