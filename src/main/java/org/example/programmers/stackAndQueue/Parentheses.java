package org.example.programmers.stackAndQueue;

import java.util.Stack;

public class Parentheses {

    public static void main(String[] args) {
        String s = "(())()";
        Stack<Character> stack = new Stack<>();
        boolean resultValue = true;

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) == '(' ){
                stack.push('(');
            }else if( s.charAt(i) == ')' ){
                if( stack.empty() ){
                    resultValue = false;
                    break;
                }
                stack.pop();
            }
        }
        if( !stack.empty() ){
            resultValue = false;
        }

        System.out.println(" 결과 값   ::  " + resultValue);

    }
}
