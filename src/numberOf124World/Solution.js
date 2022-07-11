/*
  문제 이름: 124 나라의 숫자
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12899?language=javascript
  알고리즘: 구현
  자료구조: 배열
*/

function solution(n) {
  let answer = "";

  const num = [1, 2, 4];
  while (true) {
    let quotient = Math.floor(n / 3);
    let remainder = Math.floor(n % 3);

    if (remainder === 0) {
      quotient -= 1;
      remainder = 3;
    }

    answer += num[remainder - 1];
    n = quotient;

    if (quotient < 3) {
      if (quotient !== 0) {
        answer += quotient;
      }
      break;
    }
  }

  return answer.split("").reverse().join("");
}