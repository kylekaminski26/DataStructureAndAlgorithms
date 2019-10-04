package stackDriver;

import stack.*;
import java.util.Scanner;

/**
 * Evaluate postfix expressions Assume that numbers and operators are separated
 * by one space. Assume that the expressions are well-formed.
 * @author Kyle Kaminski
 * @version Feb 2019 */
public class LabPostfix {
	// read postfix expressions from the keyboard, and evaluate
	public static void main(String[] args) {
		postfixEval();
	}

	public static void postfixEval() {
		Stack<Integer> stack = new Stack<Integer>();

		// read expression from the keyboard
		Scanner scanner = new Scanner(System.in);

		String input; // store an entire expression
		String[] opInts; // Each string is an operator or an int.
		int right; // store right operand

		System.out.println("Enter postfix expressions, or Enter to terminate");
		input = scanner.nextLine();
		while (input.length() > 0) // Empty input line terminates the program
		{
			opInts = input.split(" "); // An array of Strings, delimiter is space
			char first; // Checks the first character of the input.
			// If it is a digit, then input is number. If operator, then operator.
			for (String s : opInts) { // Is the string s a number or operator?
				int in = 0; // Integer value to store ints to push onto stack.
				first = (s.charAt(0)); // Checks the first char of the input.
				if (Character.isDigit(first)) { // If first char of input is a digit.
					in = Integer.parseInt(s); // Store the integer value in an int.
					stack.push(in); // Push int onto stack.
				} else { // If the first char of input is an operator.
					int val1 = stack.pop(); // Pop first value from stack.
					int val2 = stack.pop(); // Pop second value from stack.
					// These two values will perform the operation that was pushed onto the stack.
					// (val2 ? val1) = output. Output is pushed back onto stack.

					switch (first) { // Which operator was pushed onto stack?
					case '+':
						stack.push(val2 + val1);
						break;

					case '-':
						stack.push(val2 - val1);
						break;

					case '/':
						stack.push(val2 / val1);
						break;

					case '*':
						stack.push(val2 * val1);
						break;

					case '%': // Equals the remainder of (val2 / val1).
						stack.push(val2 % val1);
						break;
					}
				}
			}
			System.out.println(stack);
			return; // End while loop.
		} // reached end of an expression
		if (!stack.isEmpty())
			System.out.println(stack.peek());
		stack.clear();
		input = scanner.nextLine();
	}
}