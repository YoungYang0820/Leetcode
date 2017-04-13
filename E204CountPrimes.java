/**
 * Created by yangjiawei on 2017/4/13.
 */
public class E204CountPrimes {
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int primeCount = 0;
        for (int i = 2; i < n; i++) primes[i] = true;
        for (int i = 2; i * i < n; i++)
            if (primes[i])
                for (int j = i * i; j < n; j += i) primes[j] = false;
        for (int i = 2; i < n; i++)
            if (primes[i]) primeCount++;
        return primeCount;
    }
    public static void main(String[] args) {
        System.out.print(countPrimes(10));
    }
}
