package org.example.chapter5;

import java.util.HashMap;
import java.util.HashSet;

public class Solution7 {
    public static void main(String[] args){
        String dirs = "LLULLRRURLR";
        System.out.println(solution(dirs));
    }

    public static int solution(String dirs){
        int[] location = {0, 0};
        HashMap<Character, int[]> move = new HashMap<>();
        HashSet<String> moveLength = new HashSet<>();

        move.put('U', new int[]{0, 1});
        move.put('D', new int[]{0, -1});
        move.put('L', new int[]{-1, 0});
        move.put('R', new int[]{1, 0});

        for(int i = 0; i< dirs.length(); i++){
            int[] moving = move.get(dirs.charAt(i));
            if(location[0]+moving[0] < -5 || location[0]+moving[0] > 5){
                continue;
            } else if (location[1] + moving[1] < -5 || location[1] + moving[1] > 5) {
                continue;
            }
            moveLength.add(location[0]+" "+location[1]+"->"+(location[0] + moving[0])+" "+(location[1] + moving[1]));
            moveLength.add((location[0] + moving[0])+" "+(location[1] + moving[1])+"->"+location[0]+" "+location[1]);
            location[0] = location[0] + moving[0];
            location[1] = location[1] + moving[1];
        }

        return moveLength.size() / 2;
    }
}
