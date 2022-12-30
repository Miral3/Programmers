/*
  문제 이름: 유사 칸토어 비트열
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/148652
  알고리즘: 백트래킹
  자료구조: 배열
*/

function solution(n, l, r) {
  function dfs(num) {
    if (num <= 5) {
      let count = 0;
      const arr = [1, 1, 0, 1, 1];
      for (let i = 0; i < num; i++) {
        if (arr[i] === 1) {
          count++;
        }
      }
      return count;
    }

    let base = 1;
    while (Math.pow(5, base + 1) < num) {
      base += 1;
    }

    const section = Math.floor(num / Math.pow(5, base));
    const remain = num % Math.pow(5, base);

    let answer = section * Math.pow(4, base);

    if (section >= 3) {
      answer -= Math.pow(4, base);
    }

    if (section === 2) {
      return answer;
    } else {
      return answer + dfs(remain);
    }
  }

  return dfs(r) - dfs(l - 1);
}