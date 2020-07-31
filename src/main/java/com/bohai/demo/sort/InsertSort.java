package com.bohai.demo.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public int[] sort(int[] src){

        for (int i = 1; i < src.length; i++) {

            int tmp = src[i];
            int j = i;

            while (j > 0 && tmp < src[j-1]){
                src[j] = src[j-1];
                j--;
            }

            if (j != i){
                src[j] = tmp;
            }
        }

        return src;
    }
}
