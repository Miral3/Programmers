package coloringBook;

/*
문제 이름: 카카오프렌즈 컬러링북
링크: https://programmers.co.kr/learn/courses/30/lessons/1829?language=java
알고리즘: bfs
자료구조: 배열, 큐
*/


import java.util.LinkedList;
import java.util.Queue;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class solution {
    static boolean[][] isVisited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1},
                {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
        int[] ans = solution(m, n, picture);

        for(int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((!isVisited[i][j]) && picture[i][j] != 0) {
                    isVisited[i][j] = true;
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(bfs(i, j, m, n, picture), maxSizeOfOneArea);
                }
            }
        }



        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int bfs(int startY, int startX, int m, int n, int[][] pricture) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(startY, startX));
        int num = pricture[startY][startX];
        int cnt = 1;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int y = cur.y;
            int x = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= m || nx >= n) {
                    continue;
                }

                if (isVisited[ny][nx] || pricture[ny][nx] != num) {
                    continue;
                }

                isVisited[ny][nx] = true;
                que.add(new Node(ny, nx));
                cnt++;
            }
        }

        return cnt;
    }
}
