package CoPrimeNumber;

import java.math.BigInteger;

public class Demo3 {
    public static void main(String[] args){
        BigInteger x = new BigInteger("5");
        BigInteger y = new BigInteger("6");

        isCoPrime(x, y);
    }

    public static void isCoPrime(BigInteger x, BigInteger y){
        BigInteger z = x.gcd(y);

        if (z.intValue() == 1)
            System.out.println("Numbers are co primes");
        else
            System.out.println("Numbers are not co primes");
    }
}
