package org.example.chapter10;

import java.util.ArrayList;

public class Solution30 {
    public static int[] parents;

    public static void main(String[] args){
        int k = 3;
        int[][] operation = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
        Boolean[] result = solution(k, operation);

        for (int i = 0; i< result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static Boolean[] solution(int k, int[][] operations){
        parents = new int[k];
        for (int i = 0; i<k; i++){
            parents[i] = i;
        }

        ArrayList<Boolean> result = new ArrayList<>();
        for (int i = 0; i< operations.length; i++){
            if(operations[i][0] == 0){
                union(operations[i][1], operations[i][2]);
            }
            else if(operations[i][0] == 1){
                int n1 = find(operations[i][1]);
                int n2 = find(operations[i][2]);
                if(n1 == n2){
                    result.add(true);
                    continue;
                }
                result.add(false);
            }
        }

        return result.toArray(new Boolean[0]);
    }

    public static int find(int n){
        if(parents[n] == n) return n;
        return find(parents[n]);
    }

    public static void union(int n1, int n2){
        int n1Parent = find(n1);
        int n2Parent = find(n2);

        if(n1Parent != n2Parent){
            parents[n2Parent] = n1Parent;
        }
    }
}
