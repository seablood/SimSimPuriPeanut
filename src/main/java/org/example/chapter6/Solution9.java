package org.example.chapter6;

import java.util.Stack;

public class Solution9 {
    public static void main(String[] args){
        Integer decimal = 12345;
        Stack deque = solution(decimal);
        while (!deque.isEmpty()){
            System.out.print(deque.pop());
        }
    }

    public static Stack<Integer> solution(Integer decimal){
        Stack<Integer> deque = new Stack<>();

        while (!decimal.equals(1)){
            deque.add(decimal % 2);
            decimal /= 2;
        }
        deque.add(decimal);

        return deque;
    }
}
