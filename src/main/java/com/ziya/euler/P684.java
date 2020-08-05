package com.ziya.euler;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=684
 *
 * @author 鹏亮
 * @date 2020/8/3 17:33
 */
public class P684 {

    public static void main(String[] args) {
        long a1 = System.currentTimeMillis();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 2; i <= 90; i++) {
            sum = sum.add(sn(f5(i)));
        }
        System.out.println(sum.mod(BigInteger.valueOf(1000000007)));
        System.out.println("used:" + (System.currentTimeMillis() - a1) / 1000f);
    }

    public static BigInteger sn(BigInteger n) {
        BigInteger hn = n.divide(BigInteger.valueOf(9));
        BigInteger ys = n.mod(BigInteger.valueOf(9));
        StringBuilder s = new StringBuilder();
        for (long i = 0; i < hn.longValue(); i++) {
            s.append(9);
        }
        return new BigInteger(ys + "" + s);
    }

    //二进制模幂解法
    private static BigInteger f5(int n) {
        BigInteger[] add_on = {BigInteger.valueOf(2), BigInteger.valueOf(-2)};
        BigInteger prev_num = BigInteger.ONE;
        BigInteger current_num = BigInteger.ONE;
        String nb = Integer.toBinaryString(n);
        for (int i = 0; i < nb.length() - 1; i++) {
            if (nb.charAt(i) == '1') {
                //prev_num = F[2k] = F[2k+1] - F[2k-1]，current_num就是等于F[2k+1]
                prev_num = current_num.subtract(prev_num);
            } else {
                //prev_num就是等于F[2k-1]，current_num = F[2k] = F[2k+1] - F[2k-1]
                current_num = current_num.subtract(prev_num);
            }

            BigInteger sq_prev_num = prev_num.pow(2);
            BigInteger sq_current_num = current_num.pow(2);
            //F[2k-1] = F[k]^2 + F[k-1]^2
            prev_num = sq_prev_num.add(sq_current_num);
            //F[2k+1] = 4*F[k]^2 - F[k-1]^2 + 2*(-1)^k
            current_num = (sq_current_num.multiply(BigInteger.valueOf(4))).subtract(sq_prev_num)
                    .add(add_on[nb.charAt(i) == '1' ? 1 : 0]);
        }
        if ((n & 1) == 0) {
            current_num = current_num.subtract(prev_num);
        }
        return current_num;
    }
}
