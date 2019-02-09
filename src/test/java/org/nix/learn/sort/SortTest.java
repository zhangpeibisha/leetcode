package org.nix.learn.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    AbstractSort sort;

    int[] nums = new int[]{5, 8, 1, 2, 6, 5, 4, 2};

    int[] result = new int[]{1, 2, 2, 4, 5, 5, 6, 8};

    @Test
    void insertSort() {
        sort = new InsertSort();
    }

    @Test
    void bubbleSort() {
        sort = new BubbleSort();
    }

    @Test
    void chooseSort() {
        sort = new ChooseSort();
    }

    @Test
    void quickSort() {
        sort = new QuickSort();
    }

    @AfterEach
    public void afterMethod() {
        sort.run(nums);
        assertArrayEquals(result, nums);
    }
}