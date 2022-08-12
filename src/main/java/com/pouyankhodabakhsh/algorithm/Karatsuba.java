package com.pouyankhodabakhsh.algorithm;

import com.google.common.math.IntMath;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Karatsuba {

    static BigDecimal karatsuba(String x, String y, int n) {

        String firstHalfX =  x.substring(0, IntMath.divide(n,2, RoundingMode.UP));
        String secondHalfX = x.substring(IntMath.divide(n,2, RoundingMode.UP));
        String firstHalfY = y.substring(0, IntMath.divide(n,2, RoundingMode.UP));
        String secondHalfY = y.substring(IntMath.divide(n,2, RoundingMode.UP));
        padding(n, firstHalfX, firstHalfY);
        padding(n, secondHalfX, secondHalfY);
        if (n == 1) {
            return new BigDecimal(x).multiply(new BigDecimal(y));
        } else {
            karatsuba(firstHalfX, firstHalfY, IntMath.divide(n,2, RoundingMode.UP));
            karatsuba(secondHalfX, secondHalfY, IntMath.divide(n,2, RoundingMode.UP));
            BigDecimal p = new BigDecimal(firstHalfX).add(new BigDecimal(secondHalfX));
            BigDecimal q = new BigDecimal(firstHalfY).add(new BigDecimal(secondHalfY));
            karatsuba(p.toString(), q.toString(), IntMath.divide(n,2, RoundingMode.UP));
        }
        BigDecimal pow10 = BigDecimal.valueOf(Math.pow(10.0, n));
        BigDecimal pow102 = BigDecimal.valueOf(Math.pow(10.0, (double) n/2));
        BigDecimal a= new BigDecimal(firstHalfX);
        BigDecimal c= new BigDecimal(firstHalfY);
        BigDecimal ac = a.multiply(c);
        BigDecimal b = new BigDecimal(secondHalfX);
        BigDecimal d = new BigDecimal(secondHalfY);
        BigDecimal bd = b.multiply(d);
        return pow10
                .multiply(ac)
                .add(pow102
                        .multiply(((a.add(b))
                                .multiply(c.add(d)))
                                .subtract(ac).subtract(bd))).add(bd);
    }

    private static void padding(int n, String str1, String str2) {
        if (str1.length() != IntMath.divide(n,2, RoundingMode.UP)) {
            StringUtils.leftPad(str1, IntMath.divide(n,2, RoundingMode.UP) - str1.length());
        }
        if (str2.length() != IntMath.divide(n,2, RoundingMode.UP)) {
            StringUtils.leftPad(str2,IntMath.divide(n,2, RoundingMode.UP) - str2.length());
        }
    }
}
