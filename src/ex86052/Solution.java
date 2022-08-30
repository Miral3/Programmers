package ex86052;

/*
  문제 이름: 빛의 경로 사이클
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/86052?language=java
  알고리즘: 구현
  자료구조: 구현
*/

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int n;
    static int m;
    static boolean[][][] isVisited;

    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        isVisited = new boolean[n][m][4];

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 0: 동, 1: 서, 2: 남, 3: 북
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[i][j][d]) {
                        result.add(lightRoute(grid, i, j, d));
                    }
                }
            }
        }

        Collections.sort(result);
        int[] answer = new int[result.size()];
        int idx = 0;
        for (int val : result) {
            answer[idx++] = val;
        }
        return answer;
    }
    public static int lightRoute(String[] grid, int y, int x, int d) {
        int cnt = 0;

        while (true) {
            if (isVisited[y][x][d]) {
                break;
            }

            cnt++;
            isVisited[y][x][d] = true;

            char ch = grid[y].charAt(x);
            if (ch == 'L') {
                d = d == 0 ? 3 : (d + 1) % 3;
            } else if (ch == 'R') {
                d = d == 2 ? 1 : (d + 2) % 5;
            }

            y = (y + dy[d] + n) % n;
            x = (x + dx[d] + m) % m;
        }

        return cnt;
    }
}


