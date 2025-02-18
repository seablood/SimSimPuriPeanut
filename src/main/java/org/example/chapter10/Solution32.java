package org.example.chapter10;

import java.util.HashSet;

public class Solution32 {
    public static void main(String[] args){
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] result = solution(n, words);

        for (int i = 0; i< result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int[] solution(int n, String[] words){
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int size = 1;
        char c = words[0].charAt(words[0].length()-1);
        int[] result = new int[2];

        for (int i = 1; i< words.length; i++){
            String word = words[i];
            set.add(word);
            if(word.length() == 1 || (size == set.size() || c != word.charAt(0))){
                result[0] = (i % n) + 1;
                result[1] = (i / n) + 1;
                return result;
            }
            size = set.size();
            c = word.charAt(word.length()-1);
        }

        return result;
    }
}
