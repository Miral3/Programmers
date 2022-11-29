/*
  문제 이름: 기사단원의 무기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/136798
  알고리즘: 구현, 수학
  자료구조:
*/

function solution(number, limit, power) {
  function getDivisorCnt(n) {
    let cnt = 0;
    for (let i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        cnt++;
        if (i * i < n) {
          cnt++;
        }
      }
    }
    return cnt;
  }
  let answer = 0;
  for (let i = 1; i <= number; i++) {
    const cnt = getDivisorCnt(i);
    if (cnt <= limit) {
      answer += cnt;
    } else {
      answer += power;
    }
  }
  return answer;
}