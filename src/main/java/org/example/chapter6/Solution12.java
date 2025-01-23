package org.example.chapter6;

import java.util.Stack;

public class Solution12 { // 효율성 테스트 통과 X
    public static void main(String[] args){
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution2(prices);
        for(int i = 0; i< prices.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int[] solution(int[] prices){
        int[] result = new int[prices.length];

        for(int i = 0; i< prices.length; i++){
            Stack<Integer> stack = new Stack<>();
            int n = prices[i];
            for(int j = i+1; j< prices.length; j++){
                if(n <= prices[j]) stack.push(prices[j]);
                else {
                    stack.push(0);
                    break;
                }
            }

            result[i] = stack.size();
        }

        return result;
    }

    public static int[] solution2(int[] prices){ // O(N) 알고리즘용 풀이(스택에 인덱스 값을 저장해 값이 떨어지지 않은 시간을 계산하는 방식)
        int length = prices.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< length; i++){
            if(stack.isEmpty() || prices[i] >= prices[stack.peek()]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                    int n = stack.pop();
                    result[n] = i - n;
                }
                stack.push(i);
            }

            if(i == length-1){
                stack.pop();
                while (!stack.isEmpty()){
                    int n = stack.pop();
                    result[n] = i - n;
                }
            }
        }

        return result;
    }
}
