package org.example.chapter10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution31 {
    public static void main(String[] args){
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet :: new));
        int availableNum = nums.length / 2;

        if(set.size() >= availableNum) return availableNum;
        return set.size();
    }
}
