/*
  문제 이름: 귤 고르기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/138476
  알고리즘: 구현, 정렬
  자료구조: 객체
*/

function solution(k, tangerine) {
  let answer = 0;
  const tDict = {};
  tangerine.forEach((t) => (tDict[t] = (tDict[t] || 0) + 1));
  const tArray = Object.values(tDict).sort((a, b) => b - a);
  for (const cnt of tArray) {
    k -= cnt;
    answer++;
    if (k <= 0) {
      return answer;
    }
  }
}