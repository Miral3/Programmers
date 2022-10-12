package ex12987;

/*
  문제 이름: 숫자 게임
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12987#
  알고리즘: 이분탐색
  자료구조: 배열
*/

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        if (A[n - 1] < B[0]) {
            return n;
        }
        if (A[0] >= B[n - 1]) {
            return answer;
        }

        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int target = A[i];
            int left = 0;
            int right = n - 1;
            int mid;
            while (left < right) {
                mid = (left + right) / 2;

                if (B[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = right; j < n; j++) {
                if (j == n-1 && target >= B[j]) {
                    break;
                }
                if (!isVisited[j]) {
                    isVisited[j] = true;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
