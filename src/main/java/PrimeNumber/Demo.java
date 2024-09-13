package PrimeNumber;
import java.util.Scanner;  // Import the Scanner class

public class Demo {

  public static void main(String[] args) {

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter a number: ");

    int num = myObj.nextInt();  // Read user input
    System.out.println("number is: " + num);  // Output user input
//    int num = 29;
    boolean flag = false;

    // 0 and 1 are not prime numbers
    if (num == 0 || num == 1) {
        flag = true;
    }

    for (int i = 2; i <= num / 2; ++i) {

      // condition for nonprime number
      if (num % i == 0) {
        flag = true;
        break;
      }
    }

    if (!flag)
      System.out.println(num + " is a prime number.");
    else
      System.out.println(num + " is not a prime number.");
  }
}