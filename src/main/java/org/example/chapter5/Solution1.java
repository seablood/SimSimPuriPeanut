package org.example.chapter5;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args){
        int[] arr = {1, -5, 2, 4, 3};
        arr = solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] solution(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
}
