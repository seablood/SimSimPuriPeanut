package org.example.chapter6;

import java.util.Stack;

public class Solution10 {
    public static void main(String[] args){
        String s = "}]()[{";
        System.out.println(solution(s));
    }

    public static int solution(String s){
        int result = 0;

        for(int i = 0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            for(int j = i; j<i+s.length(); j++){
                char c = s.charAt(j % s.length());
                if(c == '[' || c == '{' || c == '(') stack.push(c);
                else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else {
                        stack.push(c);
                        break;
                    }
                }
                else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else {
                        stack.push(c);
                        break;
                    }
                }
                else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else {
                        stack.push(c);
                        break;
                    }
                }
            }

            if(stack.isEmpty()) result++;
        }

        return result;
    }
}
