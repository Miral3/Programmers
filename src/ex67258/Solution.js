/*
  문제 이름: [카카오 인턴] 보석 쇼핑
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/67258?language=javascript
  알고리즘: 투포인터
  자료구조: 해시 셋, 해시 맵
*/

function solution(gems) {
  const gemsCnt = new Set(gems).size;
  const n = gems.length;
  let left = 0;
  let right = 0;
  const map = new Map();
  let answer = [1, n];
  while (left <= n && right <= n) {
    if (map.size === gemsCnt) {
      if (right - left <= answer[1] - answer[0]) {
        answer = [left + 1, right];
      }
      map.set(gems[left], map.get(gems[left]) - 1);
      if (map.get(gems[left]) === 0) {
        map.delete(gems[left]);
      }
      left++;
    } else {
      map.set(gems[right], (map.get(gems[right]) || 0) + 1);
      right++;
    }
  }
  return answer;
}