package org.example.chapter7;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution17 {
    public static void main(String[] args){

    }

    public static String solution(String[] cards1, String[] cards2, String[] goal){
        Queue<String> card1 = new ArrayDeque<>(List.of(cards1));
        Queue<String> card2 = new ArrayDeque<>(List.of(cards2));
        Queue<String> goalQ = new ArrayDeque<>(List.of(goal));

        while (!goalQ.isEmpty()){
            String g = goalQ.poll();

            if(!card1.isEmpty() && card1.peek().equals(g)){
                card1.poll();
                continue;
            } else if (!card2.isEmpty() && card2.peek().equals(g)) {
                card2.poll();
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}
