package org.example.chapter5;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args){
        int[][] student = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] answers = {1, 3, 2, 4, 2};

        int[] result = solution(student, answers);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[][] student, int[] answers){
        int[] result = new int[3];

        for(int i = 0; i< answers.length; i++){
            for(int j = 0; j< result.length; j++){
                if(student[j][i % student[j].length] == answers[i]) result[j]+=1;
            }
        }

        int max = Arrays.stream(result).max().getAsInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i< result.length; i++){
            if(max == result[i]) list.add(i+1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
