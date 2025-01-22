package org.example.chapter5;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
    public static void main(String[] args){
        int[] arr = {2, 1, 1, 3, 2, 5, 4};
        arr = solution(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] solution(int[] arr){
        Integer[] array = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }
}
