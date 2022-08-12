package com.pouyankhodabakhsh.algorithm;

import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.pouyankhodabakhsh.algorithm.config.Configuration;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Inversions {

    long count = 0;
    public int[] readFile() throws IOException {

        Configuration configuration = Configuration.getInstance();
        String filepath = configuration.getFilepath();
        File file = new File(filepath + "IntegerArray.txt");
        int lineNumber = 0;
        int[] array = new int[100000];
        for (String num : FileUtils.readLines(file, StandardCharsets.UTF_8)) {
            array[lineNumber] = Integer.parseInt(num.trim());
            lineNumber++;
        }

        return array;
    }


    public long sortAndCountInv(int[] array) {
        if (array.length <= 1) {
            return 0;
        } else {
            int i = 1;
            int j = 1;
            int[] firstHalf = Arrays.copyOfRange(array,0, array.length/2);
            int[] secondHalf = Arrays.copyOfRange(array, array.length/2, array.length);
            sortAndCount(i, firstHalf);
            sortAndCount(j, secondHalf);
            sortAndCountInv(firstHalf);
            sortAndCountInv(secondHalf);
            count+= mergeAndCountSplitInv(firstHalf, secondHalf, array);
        }
        return count;
    }

    private void sortAndCount(int i, int[] firstHalf) {
        while (i < firstHalf.length) {
            if (firstHalf[i - 1] > firstHalf[i]) {
                int temp = firstHalf[i - 1];
                firstHalf[i - 1] = firstHalf[i];
                firstHalf[i] = temp;
                count++;
            }
            i++;
        }
    }

    private long mergeAndCountSplitInv(int[] firstHalf, int[] secondHalf, int[] array) {
        int i = 0;
        int j = 0;
        int k = 0;
        long splitInv = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i] < secondHalf[j]) {
                array[k] = firstHalf[i];
                i++;
            } else {
                array[k] = secondHalf[j];
                j++;
                splitInv += firstHalf.length - i;
            }
            k++;
        }
        return splitInv;
    }

}
