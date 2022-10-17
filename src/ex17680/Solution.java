package ex17680;

/*
  문제 이름: [1차] 캐시
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/17680
  알고리즘: 구현
  자료구조: 큐
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int result = solution.solution(cacheSize, cities);
        System.out.println(result);
    }
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for (String city : cities) {
            String lowerCase = city.toLowerCase();
            if (!cache.isEmpty() && cache.contains(lowerCase)) {
                cache.remove(lowerCase);
                cache.add(lowerCase);
                answer += 1;
            } else {
                cache.add(lowerCase);
                if (cache.size() > cacheSize) {
                    cache.poll();
                }
                answer += 5;
            }
        }
        return answer;
    }
}
