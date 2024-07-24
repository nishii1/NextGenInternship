package Calculator;

import java.util.Scanner;

public class JavaTestClass {
    public static void main(String[] args){
        int operator, n1, n2;
        System.out.println("1 - Add \n 2 - Subtract \n 3 - Multiply \n 4 - Divide \n");
        System.out.println("Choose Operator: ");
        Scanner sc = new Scanner(System.in);
        operator = sc.nextInt();
        System.out.println("Enter first number : ");
        n1 = sc.nextInt();
        System.out.println("Enter second number : ");
        n2 = sc.nextInt();

        int result = 0;
        switch(operator){
            case 1:
                result = n1 + n2;
                break;
            case 2:
                result = n1 - n2;
                break;
            case 3:
                result = n1 * n2;
                break;
            case 4:
                result = n1 / n2;
                break;

            default:
                System.out.println("Entered operator is not valid");
        }
        System.out.println("Result : " + result);
    }
}
