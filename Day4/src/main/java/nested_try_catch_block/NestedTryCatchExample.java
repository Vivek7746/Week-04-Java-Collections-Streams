package nested_try_catch_block;

import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Initialising the array
        int[] arr = {1,2,3,4,5};

        // Taking divisor and an index as an input
        System.out.println("Enter the divisor and index[0-4]");
        int divisor = input.nextInt();
        int index = input.nextInt();

        // Outer try block
        try {
            int valAtindex = arr[index];

            // Inner try block
            try {
                System.out.println("arr[index] / divisor : " + arr[index]/divisor);
            }
            catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}