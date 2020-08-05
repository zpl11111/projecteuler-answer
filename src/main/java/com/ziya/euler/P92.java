package com.ziya.euler;

import java.util.*;

/**
 * 平方数字链
 * <p>
 * 将一个数的所有数字的平方相加得到一个新的数，不断重复直到新的数已经出现过为止，这构成了一条数字链。
 * <p>
 * 例如，
 * <p>
 * 44 → 32 → 13 → 10 → 1 → 1
 * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
 * <p>
 * 可见，任何一个到达1或89的数字链都会陷入无尽的循环。更令人惊奇的是，从任意数开始，最终都会到达1或89。
 * <p>
 * 有多少个小于一千万的数最终会到达89？
 *
 * @author 鹏亮
 * @date 2020/8/3 16:03
 */
public class P92 {
    static Set<Integer> inset = new HashSet<>();
    static Set<Integer> noset = new HashSet<>();

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for (int i = 1; i < 10000000; i++) {
            if (inset.contains(i) || noset.contains(i)) {
                continue;
            }
            cap(i);
        }
        System.out.println(inset.size());
        System.out.println("used:" + (System.currentTimeMillis() - a) / 1000f);
    }

    public static int ca(int n) {
        String s = n + "";
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += ((int) c - '0') * ((int) c - '0');
        }
        return sum;
    }

    public static int cap(int n) {
        Set<Integer> tmp = new HashSet<>();
        int fl = 0;
        while (true) {
            tmp.add(n);
            n = ca(n);
            if (n == 1) {
                fl = 1;
                break;
            } else if (n == 89) {
                fl = 89;
                break;
            }
        }
        if (fl == 1) {
            noset.addAll(tmp);
        } else {
            inset.addAll(tmp);
        }
        return n;
    }
}
