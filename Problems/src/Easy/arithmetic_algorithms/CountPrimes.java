package Easy.arithmetic_algorithms;

/*
Count the number of prime numbers less than a non-negative number, n.
 */

public class CountPrimes {
    public int countPrimes(int n) {
        int primes = 0;
        while (n != 0) {
            if(isPrime(n))
                primes++;
        }
        return primes;
    }

    public boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
