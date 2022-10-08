package ex1844;

/*
  문제 이름: 게임 맵 최단거리
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844
  알고리즘: bfs
  자료구조: 큐
*/

import java.util.*;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    static int n;
    static int m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] isVisited;
    static int[][] maps;

    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        isVisited = new int[n][m];
        this.maps = maps;
        bfs();
        if (isVisited[n - 1][m - 1] == 0) {
            answer = -1;
        } else {
            answer = isVisited[n - 1][m - 1] ;
        }
        return answer;
    }
    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        isVisited[0][0] = 1;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (maps[ny][nx] == 0 || isVisited[ny][nx] != 0) {
                    continue;
                }


                que.add(new Node(ny, nx));
                isVisited[ny][nx] = isVisited[y][x] + 1;

            }
        }

        return;
    }
}
