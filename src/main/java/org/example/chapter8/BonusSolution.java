package org.example.chapter8;

import java.util.ArrayList;
import java.util.HashMap;

public class BonusSolution {
    public static void main(String[] args){
        solution("ABABABABABABABAB");
    }

    public static int[] solution(String msg){
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 65; i<=90; i++){
            char c = (char) i;
            map.put(String.valueOf(c), i - 64);
        }

        char[] chars = msg.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(chars[0]);

        for (int i = 1; i<msg.length(); i++){
            stringBuilder.append(chars[i]);
            String s = stringBuilder.toString();
            if(!map.containsKey(s)){
                map.put(s, map.size() + 1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                result.add(map.get(stringBuilder.toString()));
                stringBuilder.delete(0, stringBuilder.length());
                i--;
            }
            if(i == msg.length()-1) result.add(map.get(stringBuilder.toString()));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
