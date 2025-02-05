package org.example.chapter8;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution21 {
    public static String[] solution(String[] record){
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (String cmd : record){
            String[] split = cmd.split(" ");
            if(split[0].equals("Enter") || split[0].equals("Change")){
                map.put(split[1], split[2]);
            }
        }

        for (String cmd : record){
            String[] split = cmd.split(" ");
            if(split[0].equals("Enter")) result.add(map.get(split[1]) + "님이 들어왔습니다.");
            else if(split[0].equals("Leave")) result.add(map.get(split[1]) + "님이 나갔습니다.");
        }

        return result.toArray(new String[0]);
    }
}
