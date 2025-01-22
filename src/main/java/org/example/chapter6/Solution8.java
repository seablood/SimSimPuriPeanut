package org.example.chapter6;

import java.util.Stack;

public class Solution8 {
    public static void main(String[] args){
        String s = "(()(";
        System.out.println(solution(s));
    }

    public static boolean solution(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
