package ex42578;

/*
  문제 이름: 위장
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42578
  알고리즘: 구현, 수학
  자료구조: 해시 맵
*/

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution.solution(clothes);
        System.out.println(result);
    }
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];

            List<String> list = new ArrayList<>();
            if (map.containsKey(type)) {
                list = map.get(type);
            }
            list.add(name);

            map.put(type, list);
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key).size() + 1);
        }

        answer -= 1;
        return answer;
    }
}
