/*
  문제 이름: 점 찍기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/140107?language=javascript
  알고리즘: 수학
  자료구조: 
*/

function solution(k, d) {
  let answer = 0;
  for (let i = 0; i <= d; i += k) {
    const j = Math.sqrt(d * d - i * i);
    answer += Math.floor(j / k) + 1;
  }
  return answer;
}