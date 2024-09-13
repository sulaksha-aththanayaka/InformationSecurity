package Euclidean;

import java.math.BigInteger;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args){
        BigInteger x = new BigInteger("24");
        BigInteger y = new BigInteger("9");
        int result = euclidean();
    }

    public static int euclidean(){
        BigInteger x, y;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        String str_x = scanner.nextLine();
        x = new BigInteger(str_x);

        System.out.print("Enter y: ");
        String str_y = scanner.nextLine();
        y = new BigInteger(str_y);

        while(y.compareTo(BigInteger.ZERO) != 0){
            System.out.println();

//            BigInteger z = BigInteger.valueOf(0);
            BigInteger z = x;

            x = y;
            y = z.mod(y);
        }

        System.out.println("gcd :" + x);

        return x.intValue();
    }
}
