package org.example.chapter8;

import java.util.*;

public class Solution23 {
    public static void main(String[] args){
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] result = solution2(id_list, report, k);

        for (int i = 0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k){ // 본인 풀이
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, HashSet<String>> list = new HashMap<>();
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
        ArrayList<String> disable = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (String string : reportSet){
            String[] split = string.split(" ");
            count.put(split[1], count.getOrDefault(split[1], 0) + 1);
            if(count.get(split[1]) >= k) disable.add(split[1]);
            if(!list.containsKey(split[0])) list.put(split[0], new HashSet<>());
            HashSet<String> set = list.get(split[0]);
            set.add(split[1]);
            list.put(split[0], set);
        }

        for (String id : id_list){
            int n = 0;
            if(list.containsKey(id)){
                HashSet<String> set = list.get(id);
                for (String dis : disable){
                    if(set.contains(dis)) n++;
                }
            }
            result.add(n);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution2(String[] id_list, String[] report, int k){ // 해시셋에 신고를 한 사람을 저장하는 방식으로 다시 풀이
        HashMap<String, Integer> count = new HashMap<>();
        HashMap<String, HashSet<String>> list = new HashMap<>();
        int[] result = new int[id_list.length];

        for (int i = 0; i< report.length; i++){
            String[] split = report[i].split(" ");
            String p1 = split[0];
            String p2 = split[1];

            if(!list.containsKey(p2)) list.put(p2, list.getOrDefault(p2, new HashSet<>()));
            HashSet<String> set = list.get(p2);
            set.add(p1);
        }

        for (int i = 0; i< id_list.length; i++){
            count.put(id_list[i], i);
        }

        for (Map.Entry<String, HashSet<String>> entry : list.entrySet()){
            if(entry.getValue().size() >= k){
                for (String id : entry.getValue()){
                    result[count.get(id)]++;
                }
            }
        }

        return result;
    }
}
