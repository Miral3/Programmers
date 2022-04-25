/*
  문제 이름: 게임 맵  최단거리
  링크: https://programmers.co.kr/learn/courses/30/lessons/1844?language=javascript
  알고리즘: bfs
  자료구조: 배열, 큐
*/

function solution(maps) {
  let answer = -1;
  const dy = [-1, 1, 0, 0];
  const dx = [0, 0, -1, 1];
  const n = maps.length;
  const m = maps[0].length;

  function BFS() {
    const queue = [];
    const isVisited = Array.from(Array(n), () => new Array(m).fill(false));
    queue.push({ y: 0, x: 0, cnt: 1 });
    isVisited[0][0] = true;

    while (queue.length > 0) {
      const cur = queue.shift();
      const y = cur.y;
      const x = cur.x;
      const cnt = cur.cnt;

      if (y === n - 1 && x === m - 1) {
        answer = cnt;
        break;
      }
      for (let i = 0; i < 4; i++) {
        let ny = y + dy[i];
        let nx = x + dx[i];

        if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
          continue;
        }
        if (isVisited[ny][nx] || maps[ny][nx] === 0) {
          continue;
        }

        queue.push({ y: ny, x: nx, cnt: cnt + 1 });
        isVisited[ny][nx] = true;
      }
    }
  }

  BFS();

  return answer;
}

solution([[1, 0, 1, 1, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 1], [1, 1, 1, 0, 0], [0, 0, 0, 0, 1]]);