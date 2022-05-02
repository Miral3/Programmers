/*
문제 이름: 2xn 타일링
링크: https://programmers.co.kr/learn/courses/30/lessons/12900
알고리즘: dp
자료구조: 배열
*/

function solution(n) {
  const dp = [];
  dp[1] = 1;
  dp[2] = 2;
  for (let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
  }
  return dp[n] % 1000000007;
}