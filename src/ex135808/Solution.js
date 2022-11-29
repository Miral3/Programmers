/*
  문제 이름: 과일 장수
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/135808
  알고리즘: 구현, 정렬
  자료구조: 배열
*/

function solution(k, m, score) {
  score.sort((a, b) => b - a);
  let min = k;
  let answer = 0;
  score.forEach((s, i) => {
    if ((i + 1) % m === 1) {
      min = k;
    }
    min = Math.min(s, min);
    if ((i + 1) % m === 0) {
      answer += min * m;
    }
  });
  return answer;
}