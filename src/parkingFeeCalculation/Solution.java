package parkingFeeCalculation;

/*
  문제 이름: 주차 요금 계산
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=java
  알고리즘: 구현
  자료구조: 해시맵
*/

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        int[] result = solution.solution(fees, records);
        System.out.println(result);
    }
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> carRecord = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String[] time = record[0].split(":");
            String hour = time[0];
            String minute = time[1];
            int parseTime = Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
            String carNumber = record[1];

            if (carRecord.containsKey(carNumber)) {
                int entryTime = carRecord.get(carNumber);
                int totalTime = parseTime - entryTime;
                result.put(carNumber, result.getOrDefault(carNumber, 0) + totalTime);
                carRecord.remove(carNumber);
                continue;
            }

            carRecord.put(carNumber, parseTime);
        }

        int deadline = (23 * 60) + 59;
        for (String key : carRecord.keySet()) {
            String carNumber = key;
            int entryTime = carRecord.get(carNumber);
            int totalTime = deadline - entryTime;
            result.put(carNumber, result.getOrDefault(carNumber, 0) + totalTime);
        }

        Object[] mapkey = result.keySet().toArray();
        Arrays.sort(mapkey);

        int[] answer = new int[mapkey.length];
        for (int i = 0; i < mapkey.length; i++) {
            double defaultTime = fees[0];
            int defaultFee = fees[1];
            double unitTime = fees[2];
            int unitFee = fees[3];
            double totalTime = result.get(mapkey[i]);

            if (totalTime <= defaultTime) {
                answer[i] = defaultFee;
                continue;
            }
            answer[i] = defaultFee + (int)(Math.ceil((totalTime - defaultTime) / unitTime) * unitFee);
        }

        return answer;
    }
}
