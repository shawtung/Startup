package leetcode;

/**
 * Created by Shaw on 2015/9/7.
 */

public class CountPrimes {
    public static int countPrime(int n) {
        boolean[] x = new boolean[n];
        int cur = 1;

        while (++cur <= Math.sqrt(n))
            if (!x[cur])
                for (int i = 2; i * cur < n; i++)
                    x[cur * i] = true;

        cur = 0;

        for (int i = 2; i < n; i++)
            if (!x[i])
                cur++;

        return cur;
    }

    public static void main(String[] args){
        System.out.println(CountPrimes.countPrime(4));
    }
}
