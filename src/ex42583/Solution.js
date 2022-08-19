/*
  문제 이름: 다리를 지나는 트럭
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=javascript
  알고리즘: 큐
  자료구조: 큐
*/

function solution(bridge_length, weight, truck_weights) {
  const que = [];
  let result = 0; // 현재 시간
  let i = 0; // 건널 트럭 순서
  let n = 0; // 다리를 지나는 트럭 개수
  let w = 0; // 다리를 지나는 트럭 무게

  while (que.length !== 0 || i < truck_weights.length) {
    ++result;
    if (que.length === 0) {
      que.push({ weight: truck_weights[i], start: result });
      w = truck_weights[i];
      i++;
      n++;
      continue;
    }

    if (que[0].start + bridge_length === result) {
      const crossed = que.shift();
      n--;
      w -= crossed.weight;
    }
    if (
      i < truck_weights.length &&
      n < bridge_length &&
      weight >= w + truck_weights[i]
    ) {
      que.push({ weight: truck_weights[i], start: result });
      w += truck_weights[i];
      i++;
      n++;
    }
  }

  return result;
}

console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]));
