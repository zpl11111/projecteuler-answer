package com.ziya.euler;

/**
 * 八个约数(题目:http://pe-cn.github.io/501/)
 * <p>
 * 24的八个约数是1、2、3、4、6、8、12和24。
 * 在不超过100的数中有十个数恰好有八个约数，分别是24、30、40、42、54、56、66、70、78和88。
 * 在不超过n的数中，记有f(n)个数恰好有八个约数。
 * 已知f(100) = 10，f(1000) = 180以及f(106) = 224427。
 * 求f(1012)。
 *
 * @author 鹏亮
 * @date 2020/8/3 15:48
 */
public class P501 {
    public static int prime(long x) {
        long d;
        if ((x == 2) || (x == 3)) {
            return 1;
        }
        if (x % 2 == 0) {
            return 0;
        }
        d = 3;
        while (d * d <= x) {
            if (x % d == 0) {
                return 0;
            }
            d = d + 2;
        }

        return 1;
    }

    public static int quickPrimePi(double m, long p[]) {
        int z = 0;
        while (p[z] <= m) {
            z++;
        }

        return z;
    }

    public static long biprime(double m, int n, long p[]) {
        long d = 0;
        double qr = Math.pow(m, 0.5);
        long q = (long) qr;
        int u = n;
        while (p[u] <= q) {
            double v = (double) p[u];
            d = d + quickPrimePi((m / v), p);
            d = d - quickPrimePi(v, p);
            d++;
            u++;
        }

        return d;
    }

    public static long phiVar(double m, int b, long p[], long phisilo[][], boolean depth) {
        if (b == 0) {
            long n = (long) m;
            return n;
        } else if (m < 1.0) {
            return 0;
        } else if (((m < 250000.0) && (b < 300)) && (depth)) {
            int mi = (int) m;
            return phisilo[mi][b];
        } else {
            double q = (double) p[b - 1];
            double mq = m / q;
            return (phiVar(m, b - 1, p, phisilo, true) - phiVar(mq, b - 1, p, phisilo, true));
        }
    }

    public static long primePi(double m, long p[], long phisilo[][]) {
        double y = Math.pow(m, 0.375);
        int n = quickPrimePi(y, p);

        return phiVar(m, n, p, phisilo, true) - biprime(m, n, p) + (n - 1);
    }

    public static void main(String[] args) {
        long p[] = new long[684400];
        long phisilo[][] = new long[250000][300];
        long N = 1;
        for (int i = 0; i < 12; i++) {
            N = N * 10;
        }
        long c = 0;
        long x = 2;
        int j = 0;
        while (j < 684400) {
            if (prime(x) == 1) {
                p[j] = x;
                j++;
            }
            x++;
        }
        for (int k = 0; k < 300; k++) {
            for (int a = 0; a < 250000; a++) {
                double ar = (double) a;
                phisilo[a][k] = phiVar(ar, k, p, phisilo, false);
            }
        }

        // p^7
        int i = 0;
        while ((p[i] * p[i] * p[i] * p[i] * p[i] * p[i] * p[i]) <= N) {
            c++;
            i++;
        }

        // p^3 * q
        i = 0;
        while ((p[i] * p[i] * p[i]) <= N) {
            double m = (double) N / (double) (p[i] * p[i] * p[i]);
            long q = primePi(m, p, phisilo);
            if ((p[i] * p[i] * p[i] * p[i]) <= N) {
                q--;
            }
            c = c + q;
            i++;
        }

        // p * q * r
        i = 0;
        while ((p[i] * p[i] * p[i]) <= N) {
            j = i + 1;
            while ((p[i] * p[j] * p[j]) <= N) {
                double m = (double) N / (double) (p[i] * p[j]);
                long q = primePi(m, p, phisilo);
                c = c + (q - (j + 1));
                j++;
            }
            i++;
        }
        System.out.println(c);
    }
}
