package org.nix.learn.arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void twoSum() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = solution.twoSum(nums, target);
        assertArrayEquals(new int[]{0, 1}, ints);
    }

    @Test
    void findMedianSortedArrays() {
        int[] numsOne = new int[]{1, 2};
        int[] numsTwo = new int[]{3, 4};
        double medianSortedArrays = solution.findMedianSortedArrays(numsOne, numsTwo);
        assertEquals(2.5, medianSortedArrays);
    }
}