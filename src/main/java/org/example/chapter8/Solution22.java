package org.example.chapter8;


import java.util.*;
import java.util.stream.Stream;

public class Solution22 {
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);

        for (int i = 0; i< result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int[] solution(String[] genres, int[] plays){
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, ArrayList<int[]>> genrePlay = new HashMap<>();

        for (int i = 0; i< genres.length; i++){
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            if(!genrePlay.containsKey(genres[i])){
                genrePlay.put(genres[i], new ArrayList<>());
            }
            int[] playList = {i, plays[i]};
            genrePlay.get(genres[i]).add(playList);
        }
        Stream<Map.Entry<String, Integer>> entryStream = count.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        ArrayList<Integer> result = new ArrayList<>();
        entryStream.forEach(entry -> {
            Stream<int[]> list =
                    genrePlay.get(entry.getKey())
                            .stream()
                            .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                            .limit(2);
            list.forEach(playList -> result.add(playList[0]));
        });

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
