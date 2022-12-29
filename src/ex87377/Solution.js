/*
  문제 이름: 교점에 별 만들기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/87377
  알고리즘: 구현
  자료구조: 배열
*/

function solution(line) {
    const answer = [];
    const meet = [];
    const { length } = line;
    let xMax = -Infinity;
    let xMin = Infinity;
    let yMax = -Infinity;
    let yMin = Infinity;

    line.forEach(([a, b, e], i) => {
    for (let j = i + 1; j < length; j++) {
    const [c, d, f] = line[j];
    const denominator = a * d - b * c;
    if (denominator === 0) {
    continue;
    }
    const xMolecule = b * f - e * d;
    const yMolecule = e * c - a * f;
    if (xMolecule % denominator || yMolecule % denominator) {
    continue;
    }

    const [x, y] = [xMolecule / denominator, yMolecule / denominator];
    meet.push([x, y]);
    xMax = Math.max(x, xMax);
    xMin = Math.min(x, xMin);
    yMax = Math.max(y, yMax);
    yMin = Math.min(y, yMin);
    }
    });

    const xSize = xMax - xMin + 1;
    const ySize = yMax - yMin + 1;
    const arr = Array.from(Array(ySize).fill("."), () =>
    new Array(xSize).fill(".")
    );

    for (let [x, y] of meet) {
    arr[yMax - y][x - xMin] = "*";
    }

    for (let i = 0; i < arr.length; i++) {
    answer.push(arr[i].join("").replace(/,/gi, ""));
    }
    return answer;
    }