package org.example.chapter5;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution3 {
    public static void main(String[] args){
        int[] arr = {5, 0, 2, 7};
        arr = solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] solution(int[] arr){
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i = 0; i< arr.length-1; i++){
            for(int j = i+1; j< arr.length; j++){
                treeSet.add(arr[i]+arr[j]);
            }
        }

        return treeSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
