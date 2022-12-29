/*
  문제 이름: 테이블 해시 함수
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/147354
  알고리즘: 구현, 비트 마스크
  자료구조:
*/
function solution(data, col, row_begin, row_end) {
  data.sort((a, b) => {
    if (a[col - 1] - b[col - 1] > 0) {
      return 1;
    } else if (a[col - 1] - b[col - 1] < 0) {
      return -1;
    } else {
      return b[0] - a[0];
    }
  });

  let answer = 0;
  for (let i = row_begin; i <= row_end; i++) {
    let sum = 0;
    for (let j = 0; j < data[i - 1].length; j++) {
      sum += data[i - 1][j] % i;
    }
    answer ^= sum;
  }

  return answer;
}

console.log(
  solution(
    [
      [2, 2, 6],
      [1, 5, 10],
      [4, 2, 9],
      [3, 8, 3],
    ],
    2,
    2,
    4
  )
);
