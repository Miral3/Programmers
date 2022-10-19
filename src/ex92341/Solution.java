package ex92341;

/*
  문제 이름: 주차 요금 계산
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/92341
  알고리즘: 구현
  자료구조: 해시 맵
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Info {
    int admissionTime;
    int cumulativeTime;

    public Info (int admissionTime, int cumulativeTime) {
        this.admissionTime = admissionTime;
        this.cumulativeTime = cumulativeTime;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] result = solution.solution(fees, records);
        System.out.println(result);
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        int lastTime = calcTime("23:59");
        HashMap<String, Info> map = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            int time = calcTime(split[0]);
            String num = split[1];
            if (map.containsKey(num)) {
                Info cur = map.get(num);
                int admissionTime = cur.admissionTime;
                int cumulativeTime = cur.cumulativeTime;

                if (admissionTime != -1) {
                    map.put(num, new Info(-1, (time - admissionTime) + cumulativeTime));
                } else {
                    map.put(num, new Info(time, cumulativeTime));
                }
            } else {
                map.put(num, new Info(time, 0));
            }
        }

        for (String key : map.keySet()) {
            Info cur = map.get(key);
            int admissionTime = cur.admissionTime;
            int cumulativeTime = cur.cumulativeTime;
            if (admissionTime != -1) {
                map.put(key, new Info(-1, (lastTime - admissionTime) + cumulativeTime));
            }
        }

        List<Map.Entry<String, Info>> entries = map.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toList());

        answer = new int[entries.size()];
        int idx = 0;
        for (Map.Entry<String, Info> entry : entries) {
            Info cur = entry.getValue();
            int cumulativeTime = cur.cumulativeTime;
            int totalFee = 0;
            if (cumulativeTime <= fees[0]) {
                totalFee = fees[1];
            } else {
                totalFee = fees[1] + ((int)Math.ceil((double)(cumulativeTime - fees[0]) / fees[2])) * fees[3];
            }

            answer[idx++] = totalFee;
        }
        return answer;
    }

    public int calcTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        int result = hour * 60 + min;
        return result;
    }
}