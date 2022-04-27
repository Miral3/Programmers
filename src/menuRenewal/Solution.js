/*
문제 이름: 메뉴 리뉴얼
링크: https://programmers.co.kr/learn/courses/30/lessons/72411
알고리즘: 백트래킹
자료구조: 배열
*/

function solution(orders, course) {
  const answer = [];
  for (const num of course) {
    const counts = new Map();
    for (const order of orders) {
      if (order.length < num) {
        continue;
      }
      const arr = order.split('').sort();
      const out = [];
      const isVisited = new Array(num).fill(false);
      backTracking(0, 0, arr, out, num, isVisited, counts);
    }

    if (counts.size === 0) {
      continue;
    }

    const mapToArray = [...counts];
    mapToArray.sort((a, b) => b[1] - a[1]);
    const max = mapToArray[0][1];

    if (max === 1) {
      continue;
    }

    for (const val of mapToArray) {
      if (val[1] < max) {
        break;
      }
      answer.push(val[0]);
    }
  }

  return answer.sort();
}


function backTracking(start, depth, arr, out, num, isVisited, counts) {
  if (depth === num) {
    const orders = out.join('');
    counts.set(orders, counts.get(orders) + 1 || 1);
    return;
  }

  for (let i = start; i < arr.length; i++) {
    if (!isVisited[i]) {
      isVisited[i] = true;
      out[depth] = arr[i];
      backTracking(i + 1, depth + 1, arr, out, num, isVisited, counts);
      isVisited[i] = false;
    }
  }
}