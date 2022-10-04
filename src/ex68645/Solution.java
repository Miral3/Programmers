package ex68645;

/*
  문제 이름: 삼각 달팽이
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/68645
  알고리즘: 구현
  자료구조: 배열
*/

class Solution {
    public int[] solution(int n) {
        if (n == 1) {
            int[] answer = {1};
            return answer;
        }
        int[][] map = new int[n][n];
        int max = (n * (n + 1)) / 2;

        int y = 0;
        int x = 0;
        int dir = 0;
        int cnt = 1;
        while (true) {
            map[y][x] = cnt;
            cnt++;
            if (dir == 0) {
                if (y + 1 >= n || map[y + 1][x] != 0) {
                    dir = 1;
                    x += 1;
                    map[y][x] = cnt;
                } else {
                    y += 1;
                }
            } else if (dir == 1) {
                if (x + 1 > y || map[y][x + 1] != 0) {
                    dir = 2;
                    y -= 1;
                    x -= 1;
                    map[y][x] = cnt;
                } else {
                    x += 1;
                }
            } else if (dir == 2) {
                if (map[y - 1][x - 1] != 0) {
                    dir = 0;
                    y += 1;
                    map[y][x] = cnt;
                } else {
                    y -= 1;
                    x -= 1;
                }
            }

            if (cnt >= max) {
                break;
            }
        }

        int[] answer = new int[max];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = map[i][j];
            }
        }

        return answer;
    }
}