package CoPrimeNumber;
import java.util.Scanner;
class Demo2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("First number: ");
        int a = Integer.parseInt(in.nextLine());
        System.out.print("Second number: ");
        int b = Integer.parseInt(in.nextLine());
        if(a < 1 || b < 1){
            System.out.println("INVALID INPUT");
            return;
        }
        if(isCoPrime(a, b))
            System.out.println("They are co-primes!");
        else
            System.out.println("They are not co-primes.");
    }
    public static boolean isCoPrime(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a == 1;
    }
}
