package com.bohai.demo.sort;

public class ShellSort {

    public int[] sort(int[] src){
        int gap = 1;
        while (gap < src.length){
            gap = gap * 3 + 1;
        }

//        System.out.println("======= gap =========");
//        System.out.println(gap);
        while (gap > 0){
            for (int i = gap; i < src.length; i++) {
                int tmp = src[i];
                int j = i - gap;
                while (j >= 0 && src[j] > tmp){
                    src[j+gap] = src[j];
                    j-= gap;
                }

                src[j+gap] = tmp;
            }
//            System.out.println("+++++++++++ gap =========");
//            System.out.println(gap);
            gap = (int)Math.floor(gap/3);
//            System.out.println("/////////// gap =========");
//            System.out.println("p="+gap);
        }
        return src;
    }
}
