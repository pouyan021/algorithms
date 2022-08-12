package com.pouyankhodabakhsh.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class QuickSortTest {


    @Test
    void partition_returns_0_if_left_is_greater_than_right() {
        QuickSort quickSort = new QuickSort();
        assertThat(quickSort.partition(new int[0], 2, 1)).isZero();
    }



}
