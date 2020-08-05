package com.ziya.euler;

import java.math.BigDecimal;

/**
 * 非梅森大素数
 * <p>
 * 1999年人们发现了第一个超过一百万位的素数，这是一个梅森素数，可以表示为26972593−1，包含有2,098,960位数字。在此之后，更多形如2p−1的梅森素数被发现，其位数也越来越多。
 * <p>
 * 然而，在2004年，人们发现了一个巨大的非梅森素数，包含有2,357,207位数字：28433×27830457+1。
 * <p>
 * 找出这个素数的最后十位数字。
 *
 * @author 鹏亮
 * @date 2020/8/3 16:38
 */
public class P97 {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();

        BigDecimal a1 = BigDecimal.valueOf(2).pow(7830457).multiply(BigDecimal.valueOf(28433)).add(BigDecimal.ONE);
        System.out.println(a1.toString().substring(a1.toString().length() - 10));

        System.out.println("used:" + (System.currentTimeMillis() - a) / 1000f);
    }
}
