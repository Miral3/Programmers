package ex72411;

/*
  문제 이름: 메뉴 리뉴얼
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/72411?language=java
  알고리즘: 구현, 조합
  자료구조: 배열, 문자열, 해시맵
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    static HashMap<String, Integer> map;
    static boolean[] isVisited;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            int r = course[i];
            map = new HashMap<>();
            for (int j = 0; j < orders.length; j++) {
                int n = orders[j].length();
                if (course[i] <= n) {
                    char[] order = orders[j].toCharArray();
                    Arrays.sort(order);
                    isVisited = new boolean[n];
                    combination(0, n, r, order);
                }
            }
            if (map.size() == 0) {
                continue;
            }

            List<String> keySet = new ArrayList<>(map.keySet());
            keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

            if (map.get(keySet.get(0)) < 2) {
                continue;
            }
            for (String key : keySet) {
                if (map.get(key) == map.get(keySet.get(0))) {
                    result.add(key);
                } else {
                    break;
                }
            }
        }

        Collections.sort(result);
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }
    public static void combination(int start, int n, int r, char[] order) {
        if (r == 0) {
            String sum = "";
            for (int i = 0; i < n; i++) {
                if (isVisited[i]) {
                    sum += order[i];
                }
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }

        for (int i = start; i < n; i++) {
            isVisited[i] = true;
            combination(i + 1, n, r - 1, order);
            isVisited[i] = false;
        }
    }
}
