package ex12914;

/*
  문제 이름: 멀리 뛰기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12914
  알고리즘: 다이나믹 프로그래밍
  자료구조: 배열
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 1;
        long result = solution.solution(n);
        System.out.println(result);
    }
    public long solution(int n) {
        if (n < 3) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }
}
