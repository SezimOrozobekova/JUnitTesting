package org.example;

import java.util.Stack;

public class StringProcessor {
    public static boolean isStrongPassword(String password) {
        boolean UpperCase = false;
        boolean LowerCase = false;
        boolean digit = false;
        boolean symbol = false;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 32 && password.charAt(i) <= 47 || password.charAt(i) >= 58 && password.charAt(i) <= 64) {
                symbol = true;
            }
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                UpperCase = true;
            }
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) {
                LowerCase = true;
            }
            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                digit = true;
            }
        }

        return UpperCase && LowerCase && digit && symbol;
    }

    public static int calculateDigits(String sentence) {
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {

            if (sentence.charAt(i) >= 48 && sentence.charAt(i) <= 57) {
                count++;
            }
        }
        return count;
    }

    public static int calculateWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }
    public static double calculateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (Character.isDigit(character)) {
                // If the current character is a digit, extract the whole number
                char[] numArray = new char[expression.length()];
                int numIndex = 0;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numArray[numIndex++] = expression.charAt(i);
                    i++;
                }
                i--; // Decrement i to handle the next character in the next iteration

                // Convert the extracted number to a double and push it onto the numbers stack
                String numString = new String(numArray, 0, numIndex);
                double numValue = Double.parseDouble(numString);
                numbers.push(numValue);
            } else if (character == '+' || character == '-') {
                // Process higher precedence operators (* and /) before pushing the current operator
                while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                    evaluateExpression(numbers, operators);
                }
                operators.push(character);
            } else if (character == '*' || character == '/') {
                operators.push(character);
            }
        }

        // Evaluate any remaining operators in the stacks
        while (!operators.isEmpty()) {
            evaluateExpression(numbers, operators);
        }

        // The result should be the only element left in the numbers stack
        return numbers.pop();
    }

    private static void evaluateExpression(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = numbers.pop();
        double operand1 = numbers.pop();

        switch (operator) {
            case '+':
                numbers.push(operand1 + operand2);
                break;
            case '-':
                numbers.push(operand1 - operand2);
                break;
            case '*':
                numbers.push(operand1 * operand2);
                break;
            case '/':
                numbers.push(operand1 / operand2);
                break;
        }
    }

}