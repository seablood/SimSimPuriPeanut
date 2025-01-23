package org.example.chapter6;

import java.util.ArrayList;
import java.util.Stack;

public class Solution14 { // 고민해 봐야할 점: 너무 많은 듯한 분기점(시간복잡도(효율성)는 통과)
    public static void main(String[] args){
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        System.out.println(solution(n, k, cmd));

    }


    public static String solution(int n, int k, String[] cmd){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> delete = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<n; i++){
            list.add(i);
        }

        for(int i = 0; i< cmd.length; i++){
            char order = cmd[i].charAt(0);
            if(order == 'D' || order == 'U'){
                String num = cmd[i].split(" ")[1];
                int move = Integer.valueOf(num);
                if(order == 'D') k += move;
                else k -= move;
            }
            else if(order == 'C'){
                delete.push(list.get(k));
                list.remove(k);
                if(k > list.size()-1) k = list.size()-1;
            }
            else {
                int rollback = delete.pop();
                if(list.size()-1 < rollback){
                    list.add(rollback);
                }
                else {
                    list.add(rollback, rollback);
                    if(k >= rollback) k++;
                }
            }
        }

        for(int i = 0; i< n; i++){
            if(!delete.isEmpty() && i == delete.peek()){
                result.append('X');
                delete.pop();
            }
            else result.append('O');
        }

        return result.toString();
    }
}
