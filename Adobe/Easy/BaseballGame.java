import java.util.Stack;

public class BaseballGame {
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        // Loop through each operation
        for (int i = 0; i < operations.length; i++) {
            int c = 0;
            String ch = operations[i];
            // Case 1: "D" means double the last score
            if (ch.equals("D")) {
                stack.push(stack.peek() * 2);

            } else if (ch.equals("C")) { // Case 2: "C" means remove the last score
                stack.pop();
                // Case 3: "+" means add the last two scores and push the result
            } else if (ch.equals("+")) {
                int a = stack.pop(); // Last score
                int b = stack.peek(); // Second last score
                c = a + b; // Sum of last two
                stack.push(a); // Push back the popped score
                stack.push(c); // Push the new score
            } else { // Case 4: It's a number — convert string to int and push it
                int d = Integer.parseInt(ch);
                stack.push(d);
            }
        }

        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        String ops[] = { "5", "2", "C", "D", "+" };
        System.out.println(calPoints(ops));
    }
}
