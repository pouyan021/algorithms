package com.pouyankhodabakhsh.algorithm;

import com.pouyankhodabakhsh.algorithm.config.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class QuickSort {

    long count = 0;
    public int[] readFile() throws IOException {

        Configuration configuration = Configuration.getInstance();
        String filepath = configuration.getFilepath();
        File file = new File(filepath + "quickSort.txt");
        int lineNumber = 0;
        int[] array = new int[10000];
        for (String num : FileUtils.readLines(file, StandardCharsets.UTF_8)) {
            array[lineNumber] = Integer.parseInt(num.trim());
            lineNumber++;
        }

        return array;
    }

    public void quickSort(int[] arr, int l, int r) {
        if (r >= l) {
            int i = choosePivot(arr, l, r);
            swap(arr, l, i);
            int j = partition(arr, l, r);
            quickSort(arr, l, j - 1);
            count+= j - 1 - l;
            quickSort(arr, j + 1, r);
            count+= r - j + 1;
        }
    }

    public long getCount() {
        return count;
    }


    public int partition(int[] arr, int l, int r) {
        int p = arr[l];
        int i = l + 1;
        for (int j = l + 1; j <= r; j++) {
            if (arr[j] < p) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, l , i - 1);
        return i - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int choosePivot(int[] arr, int l, int r) {
        int middleIndex = l + (r - l) / 2;
        int median = medianOfThree(arr[l], arr[middleIndex], arr[r]);

        // find length of array
        int len = arr.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == median) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    private int medianOfThree(int a, int b, int c) {
        if ((a > b) ^ (a > c))
            return a;
        else if ((b < a) ^ (b < c))
            return b;
        else
            return c;
    }

}
