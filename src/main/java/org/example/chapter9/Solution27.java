package org.example.chapter9;

import java.util.HashMap;

public class Solution27 {
    public static void main(String[] args){
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] result = solution(enroll, referral, seller, amount);

        for (int sellPay : result) System.out.println(sellPay);
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        HashMap<String, String> enrollMap = new HashMap<>();
        HashMap<String, Integer> pay = new HashMap<>();
        for (int i = 0; i< enroll.length; i++){
            enrollMap.put(enroll[i], referral[i]);
        }

        for (int i = 0; i< seller.length; i++){
            String s = seller[i];
            int sellPay = 100 * amount[i];

            while (true){
                if((sellPay / 10) == 0){
                    pay.put(s, pay.getOrDefault(s, 0) + sellPay);
                    break;
                }
                int sellPay2 = sellPay / 10;
                sellPay = sellPay - sellPay2;
                pay.put(s, pay.getOrDefault(s, 0) + sellPay);
                sellPay = sellPay2;
                if(enrollMap.get(s).equals("-")) break;
                else s = enrollMap.get(s);
            }
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i< enroll.length; i++){
            int sellPay = pay.getOrDefault(enroll[i], 0);
            result[i] = sellPay;
        }

        return result;
    }
}
