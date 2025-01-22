package org.example.chapter6;

import java.util.Stack;

public class Solution11 {
    public static void main(String[] args){
        String s = "cdcd";
        System.out.println(solution(s));
    }

    public static int solution(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != c) stack.push(c);
            else stack.pop();
        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }
}
