package ex131127;

/*
  문제 이름: 할인 행사
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/131127
  알고리즘: 구현
  자료구조: 해시 맵
*/

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        int result = solution.solution(want, number, discount);
        System.out.println(result);
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }

        if (isSatisfied(want, number, map)) {
            answer++;
        }

        int left = 0;
        int right = 9;
        int n = discount.length;
        for (int i = 0; i < n - 10; i++) {
            String prev = discount[left];
            String next = discount[right + 1];
            map.put(prev, map.getOrDefault(prev, 0) - 1);
            map.put(next, map.getOrDefault(next, 0) + 1);
            if (isSatisfied(want, number, map)) {
                answer++;
            }
            left++;
            right++;
        }

        return answer;
    }

    public static boolean isSatisfied(String[] want, int[] number, HashMap<String, Integer> map) {
        for (int i = 0; i < want.length; i++) {
            String cur = want[i];
            if (!map.containsKey(cur) || number[i] > map.get(cur)) {
                return false;
            }
        }
        return true;
    }
}
