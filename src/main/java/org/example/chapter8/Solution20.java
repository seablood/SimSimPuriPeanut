package org.example.chapter8;

import java.util.HashMap;

public class Solution20 {
    public static int solution(String[] want, int[] number, String[] discount){
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i< want.length; i++){
            map.put(want[i], number[i]);
        }

        for (int i = 0; i< discount.length-9; i++){
            HashMap<String, Integer> disMap = new HashMap<>();
            for (int j = i; j<i+10; j++){
                if(map.containsKey(discount[j])){
                    disMap.put(discount[j], disMap.getOrDefault(discount[j], 0) + 1);
                }
            }

            if (map.equals(disMap)) result++;
        }

        return result;
    }
}
