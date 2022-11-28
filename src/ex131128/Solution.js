/*
  문제 이름: 숫자 짝꿍
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/131128
  알고리즘: 구현, 문자열, 정렬
  자료구조: 객체, 문자열
*/

function solution(X, Y) {
  const xDict = {};
  const yDict = {};
  X.split("").forEach((s) => (xDict[s] = (xDict[s] || 0) + 1));
  Y.split("").forEach((s) => (yDict[s] = (yDict[s] || 0) + 1));
  let answer = "";
  const numArr = Array.from({ length: 10 }, (_, i) => i).reverse();
  numArr.forEach((num) => {
    if (xDict[num] && yDict[num]) {
      const minCnt = Math.min(xDict[num], yDict[num]);
      answer += String(num).repeat(minCnt);
    }
  });
  if (!answer) {
    return "-1";
  }
  if (answer.charAt(0) === "0") {
    return "0";
  }
  return answer;
}