package org.example.chapter8;

import java.util.HashMap;

public class Solution19 {
    public static void main(String[] args){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));

    }

    public static String solution(String[] participant, String[] completion){
        HashMap<String, Integer> map = new HashMap<>();

        for (String part : participant){
            if(map.containsKey(part)) {
                map.put(part, map.get(part)+1);
                continue;
            }
            map.put(part, 1);
        }



        for (String com : completion){
            if(map.containsKey(com) && map.get(com) == 1){
                map.remove(com);
            }
            else if(map.containsKey(com)) map.put(com, map.get(com));
        }

        return (String) map.keySet().stream().toArray()[0];
    }
}
