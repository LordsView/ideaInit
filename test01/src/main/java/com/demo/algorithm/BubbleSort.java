package com.demo.algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9,3,6,2,6,1};
        bubbleSort(arr);
        System.err.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){//控制比较轮次，一共 n-1 趟
            for(int j=0;j<array.length-1-i;j++){//控制两个挨着的元素进行比较
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
