package ex12938;

/*
  문제 이름: 최고의 집합
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12938
  알고리즘: 수학
  자료구조: 배열
*/

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int div = s / n;
        int rest = s % n;

        if (div == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            for (int i = 0; i < n; i++) {
                answer[i] = div;
            }

            for (int i = 0; i < rest; i++) {
                answer[i] += 1;
            }
            Arrays.sort(answer);
        }

        return answer;
    }
}
