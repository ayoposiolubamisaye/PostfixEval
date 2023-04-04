// Programmer: Ayoposi Olu-Bamisaye
// Problem Statement:For this assignment, you will use write your own Stack class and use it to evaluate postfix expressions entered by the user. The Main.java has a few lines of code that read in an expression from the user and break it down into tokens. You can use it to keep asking for expressions to evaluate.
// Data In: postfix expression
// Data Out: result of expression

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // ask user for postfix expression
    public static void main(String[] args) {
        PostfixEvaluator evaluator = new PostfixEvaluator();
        try{
        Scanner input = new Scanner(System.in);

            while (true) {

                System.out.print("Enter a postfix expression: ");
                String expression = input.nextLine();


                // Use catch and try to take input gracefully
                double result = evaluator.evaluate(expression);
                System.out.println("The result is: " + result);
            }
            }catch(InputMismatchException e){
                System.out.println("An error occurred, try again");
            }
        }
    }
