/*
  문제 이름: 예상 대진
  링크: https://programmers.co.kr/learn/courses/30/lessons/12985?language=javascript
  알고리즘: 구현
  자료구조: 
*/

function solution(n, a, b) {
  let answer = 0;
  while (true) {
    a = Math.floor(a / 2) + (a % 2);
    b = Math.floor(b / 2) + (b % 2);
    answer++;
    if (a == b) {
      break;
    }
  }

  return answer;
}