package org.example.chapter5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution6 {
    public static void main(String[] args){
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int n = 5;

        int[] result = solution(stages, n);

        System.out.println(Arrays.toString(result));

    }

    public static int[] solution(int[] stages, int n){
        HashMap<Integer, Double> results = new HashMap<>();
        int[] player = new int[n+2];
        int playerNum = stages.length;
        int[] result = new int[n];

        for(int stage : stages){
            player[stage]++;
        }

        for(int i = 1; i<=5; i++){
            double playerNumDouble = playerNum;
            results.put(i, player[i] / playerNumDouble);
            playerNum-=player[i];
        }

        // 정답 풀이(뭐가 더 효율적인가? -> 시간복잡도 상으로 큰 차이 없지만 스트림 사용으로 코드가 간결해짐)
        return results.entrySet().stream().sorted(((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())))
                .mapToInt(Map.Entry::getKey).toArray();

        /*List<Integer> keySet = new ArrayList<>(results.keySet()); // 본인 풀이
        Collections.sort(keySet, ((o1, o2) -> results.get(o2).compareTo(results.get(o1))));
        for(int i = 0; i<5; i++){
            result[i] = keySet.get(i);
        }
        return result;*/
    }
}
