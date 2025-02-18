package org.example.chapter8;

import java.util.*;

public class Solution24 {
    private static HashMap<Integer, HashMap<String, Integer>> courseList = new HashMap<>();
    public static void main(String[] args){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        solution(orders, course);

    }

    public static void convolution(int idx, String target, String con){ // 모든 조합을 구하는 재귀 함수!!
        for (int i = idx; i<target.length(); i++){
            String con2 = con + target.charAt(i);
            if(courseList.containsKey(con2.length())){
                HashMap<String, Integer> map = courseList.get(con2.length());
                map.put(con2, map.getOrDefault(con2, 0) + 1);
            }
            convolution(i+1, target, con2);
        }
    }

    public static String[] solution(String[] orders, int[] course){
        for (int i : course){
            courseList.put(i, new HashMap<>());
        }

        for (int i = 0; i< orders.length; i++){
            convolution(0, orders[i], "");
        }

        ArrayList<String> result = new ArrayList<>();

        for (HashMap<String, Integer> count : courseList.values()){ // 매우 중요!! 무조건 익혀두기
            count.values().stream()
                    .max(Comparator.comparingInt(o -> o))
                    .ifPresent(cnt -> count.entrySet().stream()
                            .filter(entry -> entry.getValue() == cnt && cnt > 1)
                            .forEach(entry -> result.add(entry.getKey())));
        }

        Collections.sort(result, Collections.reverseOrder());

        return result.toArray(new String[0]);
    }
}
