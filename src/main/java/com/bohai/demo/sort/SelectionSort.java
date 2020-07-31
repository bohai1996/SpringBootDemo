package com.bohai.demo.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    public int[] sort(int[] src){

        // 经历n - 1 轮比较
        for (int i = 0; i < src.length; i++) {
            int min = i;
            // 每轮需要比较次数 n - i 次
            for (int j = i+1; j < src.length; j++) {
                if (src[j] < src[min]){
                    min = j;
                }
            }
            // 将找到最小值 与i 位置的值进行交换
            if (min != i){
                int tmp = src[i];
                src[i] = src[min];
                src[min] = tmp;
            }
        }

        return src;
    }

    public int[] sortDesc(int[] src){
        for (int i = 0; i < src.length; i++) {
            int max = i;
            for (int j = i+1; j < src.length; j++) {
                if (src[j] > src[max]){
                    max = j;
                }
            }

            if (max != i){
                int tmp = src[i];
                src[i] = src[max];
                src[max] = tmp;
            }
        }

        return src;
    }
}
