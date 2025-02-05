package org.example.chapter8;

import java.util.HashMap;

public class Solution18 {
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 9};
        int target = 10;

        System.out.println(solution(arr, target));
    }

    public static boolean solution(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< arr.length; i++){
            map.put(arr[i], target - arr[i]);
        }

        for(int i = 0; i<arr.length; i++){
            int n = map.get(arr[i]);
            if(n != arr[i] && map.containsKey(n)) return true;
        }

        return false;
    }
}
