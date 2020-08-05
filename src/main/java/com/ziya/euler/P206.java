package com.ziya.euler;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * 被遮挡的平方数
 * <p>
 * 找出唯一一个其平方形如1_2_3_4_5_6_7_8_9_0的正整数，
 * 其中每个“_”表示一位数字。
 *
 * @author 鹏亮
 * @date 2020/8/3 16:52
 */
public class P206 {
    public static void main(String[] args) {
        long a1 = System.currentTimeMillis();
        for (long i = Math.round(Math.sqrt(1020304050607080900L)); i < Math.round(Math.sqrt(1929394959697989990L)); i++) {
            String a = String.valueOf(i * i);
            if (a.charAt(0) == '1' && a.charAt(2) == '2' && a.charAt(4) == '3' && a.charAt(6) == '4' && a.charAt(8) == '5' &&
                    a.charAt(10) == '6' && a.charAt(12) == '7' && a.charAt(14) == '8' && a.charAt(16) == '9' && a.charAt(18) == '0') {
                System.out.println(i);
                break;
            }
        }
        System.out.println("used:" + (System.currentTimeMillis() - a1) / 1000f);
    }
}
