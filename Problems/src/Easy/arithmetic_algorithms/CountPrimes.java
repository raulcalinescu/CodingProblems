package Easy.arithmetic_algorithms;

/* >>>>>> UNFINISHED  <<<<

Count the number of prime numbers less than a non-negative number, n.

 n = 6;  3 primes
 2, 3, 5

 n = 10; 4 primes
 2, 3, 5, 7

 Sieve Eratosthenes' Method

    Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
    Initially, let p equal 2, the smallest prime number.
    Enumerate the multiples of p by counting in increments of p from 2p to n, and mark them in the list
            (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
    Find the first number greater than p in the list that is not marked. If there was no such number, stop.
        Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
    When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.


n = 14
[ 0,1,2,3,4,5,6,7,8,9,10,11,12,13]

p = 2


 */


public class CountPrimes {

    // ....still get time limit exceeded at n = 500k
    public static int countPrimes(int n) {
        int primes = 0, a[] = new int[n+1];
        for (int p = 2; p * p < n; p++) {
                if(a[p] == 0) {
                    //primes++;
                    int i = p * p;
                    while (i < n) {
                                           // fill up all the numbers divisible with the prime number found
                            a[i] = i;
                            primes++;
                        i = i + p;
                    }
                }
        }
        return primes;
    }



    // time limit exceeded for this Solution at input n = 499979. my runtime O(n^2)
    // Should have used the Sieve Eratosthenes' Method

/*
    public static int countPrimes(int n) {
        int primes = 0;
        while (n > 1) {
            if(isPrime(n-1))
                primes++;
                n--;
        }
        return primes;
    }

    public static boolean isPrime(int num) {
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
*/
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
