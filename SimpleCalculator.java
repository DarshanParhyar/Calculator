import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter operand1: ");
                int op1 = input.nextInt();
                System.out.print("Enter operand2: ");
                int op2 = input.nextInt();
                System.out.print("Enter Operator: ");
                char op = input.next().charAt(0);
                int result;
                switch (op) {
                    case '+':
                        result = op1 + op2;
                        System.out.println("Addition of " + op1 + " + " + op2 + " = " + result);
                        break;
                    case '-':
                        result = op1 - op2;
                        System.out.println("Subtraction of " + op1 + " - " + op2 + " = " + result);
                        break;
                    case '*':
                        result = op1 * op2;
                        System.out.println("Multiplication of " + op1 + " * " + op2 + " = " + result);
                        break;
                    case '/':
                        if (op2 == 0) {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = op1 / op2;
                        System.out.println("Division of " + op1 + " / " + op2 + " = " + result);
                        break;
                    default:
                        System.out.println("Invalid operator. Please enter one of the following: +, -, *, /");
                }

                System.out.print("Do you want to continue? (yes/no): ");
                String decision = input.next();
                if (!decision.equalsIgnoreCase("yes")) {
                    break;
                }

            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter integers for operands.");
                input.next();
            } catch (ArithmeticException ae) {
                System.out.println(ae.getMessage());
            }
        }

        input.close();
        System.out.println("Calculator has been closed.");
    }
}
