package org.example.chapter6;

import java.util.Stack;

public class Solution13 {
    public static void main(String[] args){
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));

    }

    public static int solution(int[][] board, int[] moves){
        int result = 0;
        Stack<Integer>[] boardStack = new Stack[board.length];
        Stack<Integer> pick = new Stack<>();

        for(int i = 0; i<board[0].length; i++){
            boardStack[i] = new Stack<>();
            for(int j = board.length - 1; j>=0; j--){
                if(board[j][i] != 0) boardStack[i].push(board[j][i]);
            }
        }

        for(int i = 0; i< moves.length; i++){
            int move = moves[i]-1;
            if(boardStack[move].isEmpty()) continue;

            int doll = boardStack[move].pop();
            if(!pick.isEmpty() && pick.peek() == doll){
                pick.pop();
                result += 2;
            }
            else pick.push(doll);
        }

        return result;
    }
}
