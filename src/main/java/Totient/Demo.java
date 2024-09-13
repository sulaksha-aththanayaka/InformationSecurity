package Totient;

import java.math.BigInteger;

public class Demo {


    public static boolean isCoPrime(BigInteger x, BigInteger y){
        BigInteger z = x.gcd(y);

        if (z.intValue() == 1) {
//            System.out.println("Numbers are co primes");
            return true;
        }else {
//            System.out.println("Numbers are not co primes");
            return false;
        }
    }

    public static int totient(BigInteger a){
        int count = 0;

        for (int i = 0; i < a.intValue(); i++){
            if(isCoPrime(a, BigInteger.valueOf(i))){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args){
       BigInteger num = new BigInteger("7");
       int result = totient(num);

       System.out.println("Result: " + result);
    }
}
