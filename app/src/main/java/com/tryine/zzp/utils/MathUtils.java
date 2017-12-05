package com.tryine.zzp.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Name: MathUtils
 * Details:
 * Created by PC on 2017/9/19.
 * Update:
 */

public class MathUtils {
    public static float add(float f1, float f2) {
        return add(f1, f2, "##0.00");
    }

    /**
     * @param f1
     * @param f2
     * @param format "##0.00"  "##.0.0"
     * @return
     */
    public static float add(float f1, float f2, String format) {
        BigDecimal total = new BigDecimal(f1).add(new BigDecimal(f2));
        return Float.parseFloat(new DecimalFormat(format).format(total.floatValue()));
    }

    public static float reduce(float f1, float f2) {
        return reduce(f1, f2, "##0.00");
    }

    public static float reduce(float f1, float f2, String format) {
        BigDecimal total = new BigDecimal(f1).subtract(new BigDecimal(f2));
        return Float.parseFloat(new DecimalFormat(format).format(total.floatValue()));
    }

    public static float multiply(float f1, float f2) {
        return multiply(f1, f2, "##0.00");
    }

    public static float multiply(float f1, float f2, String format) {
        BigDecimal total = new BigDecimal(f1).multiply(new BigDecimal(f2));
        return Float.parseFloat(new DecimalFormat(format).format(total.floatValue()));
    }

    public static float divide(float f1, float f2) {
        return divide(f1, f2, "##0.00");
    }

    public static float divide(float f1, float f2, String format) {
        BigDecimal total = new BigDecimal(f1).divide(new BigDecimal(f2));
        return Float.parseFloat(new DecimalFormat(format).format(total.floatValue()));
    }
}
