package ex17684;

/*
  문제 이름: [3차] 압축
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/17684
  알고리즘: 구현
  자료구조: 해시 맵
*/


import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        int[] result = solution.solution(msg);
        System.out.println(result);
    }
    public int[] solution(String msg) {
        int n = msg.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int num = 65 + i;
            char ch = (char)num;
            String str = Character.toString(ch);
            map.put(str, i + 1);
        }

        StringBuilder cur = new StringBuilder();
        String[] arr = msg.split("");
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                cur.append(arr[j]);
                if (!map.containsKey(cur.toString())) {
                    // 사전 추가
                    map.put(cur.toString(), map.size() + 1);

                    // sb 마지막 문자 제거
                    cur.deleteCharAt(cur.length() - 1);

                    result.add(map.get(cur.toString()));
                    i = j - 1;

                    // sb 초기화
                    cur.setLength(0);
                    break;
                } else if (j == n - 1) {
                    result.add(map.get(cur.toString()));
                    i = j;
                }
            }
        }
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
