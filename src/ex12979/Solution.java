package ex12979;

/*
  문제 이름: 기지국 설치
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12979?language=java
  알고리즘: 구현
  자료구조: 배열
*/

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        for (int i = 0; i < stations.length; i++) {
            if (start < stations[i] - w) {
                int end = stations[i] - w;
                int period = end - start;
                answer += period / (w * 2 +  1);
                if (period % (w * 2 +  1) != 0) {
                    answer += 1;
                }
            }
            start = stations[i] + w + 1;
        }
        if (stations[stations.length - 1] + w + 1 <= n) {
            int period = n - start + 1;
            answer += period / (w * 2 +  1);
            if (period % (w * 2 +  1) != 0) {
                answer += 1;
            }
        }
        return answer;
    }
}
