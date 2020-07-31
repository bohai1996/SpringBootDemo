package com.bohai.demo;

import com.bohai.demo.sort.BubbleSort;
import com.bohai.demo.sort.InsertSort;
import com.bohai.demo.sort.SelectionSort;
import com.bohai.demo.sort.ShellSort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SortTest {

    private static final Logger log =  LoggerFactory.getLogger(SortTest.class);

    @Test
    public void test1(){
        BubbleSort sort = new BubbleSort();
        int src[] = {4,2,1,3,5,8};
//        int[] sort1 = sort.sort(src);
//        System.out.println(sort1.toString());

        SelectionSort selectionSort = new SelectionSort();
        int[] sort1 = selectionSort.sortDesc(src);

        for (int i = 0; i < sort1.length; i++) {
            System.out.println(sort1[i]);
        }

    }

    @Test
    public void test2(){

        int src[] = {4,2,1,3,5,8};
        InsertSort insertSort = new InsertSort();
        int[] sort = insertSort.sort(src);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }

    }

    @Test
    public void test3(){
        ShellSort shellSort = new ShellSort();
        int src[] = {4,2,1,3,5,8};
        int[] sort = shellSort.sort(src);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
}
