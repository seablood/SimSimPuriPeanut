package org.example.chapter7;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution15 {
    public static void main(String[] args){
        int n = 5;
        int k = 2;
        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k){
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i<=n; i++){
            queue.add(i);
        }

        for(int i = 0; i<n-1; i++){
            for(int j = 0; j<k; j++){
                if(j == k-1){
                    queue.poll();
                    break;
                }
                int num = queue.poll();
                queue.add(num);
            }
        }

        return queue.poll();
    }
}
