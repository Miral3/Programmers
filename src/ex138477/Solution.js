/*
  문제 이름: 명예의 전당 (1)
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/138477
  알고리즘: 구현, 정렬
  자료구조: 배열
*/

function solution(k, score) {
  const arr = [];
  const answer = [];
  score.forEach((s) => {
    arr.push(s);
    arr.sort((a, b) => b - a);
    if (arr.length < k) {
      answer.push(arr[arr.length - 1]);
    } else {
      answer.push(arr[k - 1]);
    }
  });
  return answer;
}