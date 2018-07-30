package Coding;

import java.util.Stack;

public class ValidParenthesisPairs {
    public static boolean isValidParentheses(String s) {
        if(s.length() == 0 || s == null) {
            return true;
        }
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


    public boolean isValidParenthesesII(String s) {
        if (s == null || s.length() == 0)   return true;
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty())  stack.push(s.charAt(i));
            else if (s.charAt(i) - stack.peek() == 1 || s.charAt(i) - stack.peek() == 2)    stack.pop();
            else    stack.push(s.charAt(i));
        }

        return stack.empty();
    }


    // return -1 or number of pairs
    public static int isValidParenthesesIII(String s) {
        if(s.length() == 0 || s == null) {
            return 0;
        }
        Stack<Character> stack = new Stack();
        int count = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return -1;
                }
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty() ? count : -1;
    }



    public static void main(String[] args) {
        System.out.print(isValidParenthesesIII("(())()"));
    }
}
