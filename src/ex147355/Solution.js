/*
  문제 이름: 크기가 작은 부분문자열
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/147355
  알고리즘: 구현, 문자열
  자료구조: 문자열
*/

function solution(t, p) {
  let answer = 0;
  const pNum = Number(p);
  for (let i = 0; i <= t.length - p.length; i++) {
    const tNum = Number(t.substr(i, p.length));
    if (tNum <= pNum) {
      answer++;
    }
  }
  return answer;
}