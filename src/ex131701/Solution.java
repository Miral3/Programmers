package ex131701;

/*
  문제 이름: 연속 부분 수열 합의 개수
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/131701
  알고리즘: dp
  자료구조: 해시 셋
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] elements = {7,9,1,1,4};
        int result = solution.solution(elements);
        System.out.println(result);
    }
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        int[][] dp = new int[n][n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dp[0][i] = elements[i];
            set.add(elements[i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + elements[(j + i) % n];
                set.add(dp[i][j]);
            }
        }

        answer = set.size();
        return answer;
    }
}
