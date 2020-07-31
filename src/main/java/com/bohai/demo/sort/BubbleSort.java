package com.bohai.demo.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public int[] sort(int[] src){

        for (int i = 1; i < src.length; i++) {

            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < src.length -1; j++) {
                if (src[j] > src[j+1]){
                    int tmp = src[j+1];
                    src[j+1] = src[j];
                    src[j] = tmp;
                    flag = false;
                }
            }

            if (flag){
                break;
            }
        }

        return src;
    }
}
