package org.example.chapter7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution16 {
    public static void main(String[] args){
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer = solution(progresses, speeds);
        for(int n : answer) System.out.println(n);
    }

    public static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i< progresses.length; i++){
            int day = (int) Math.ceil((100-progresses[i]) / speeds[i]);
            queue.add(day);
        }

        int f = queue.poll();
        int r;
        int com = 1;
        for(int i = 1; i< progresses.length; i++){
            r = queue.poll();
            if(r <= f) {
                com++;
                continue;
            }
            f = r;
            list.add(com);
            com = 1;
        }
        list.add(com);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
