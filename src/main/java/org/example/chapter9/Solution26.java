package org.example.chapter9;

public class Solution26 {
    public static void main(String[] args){
        int n = 16;
        int a = 1;
        int b = 16;

        System.out.println(solution(n, a, b));
    }

    public static int solution(int n, int a, int b){
        int answer = 1;
        if(a > b){
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        }

        while (true){
            if(a == (b-1) && (a / 2)+1 == (b / 2)) break;
            answer++;
            if(a % 2 != 0) a = (a/2)+1;
            else a = a / 2;
            if(b % 2 != 0) b = (b/2)+1;
            else b = b / 2;
        }

        return answer;
    }
}
