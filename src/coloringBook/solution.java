package coloringBook;

import java.util.Collections;
import java.util.PriorityQueue;

public class solution {
    static int cnt;
    static boolean[][] isVisited;
    static PriorityQueue<Integer> que;
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
        int element = 0;

        cnt = 0;
        isVisited = new boolean[m][n];
        que = new PriorityQueue<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((!isVisited[i][j]) && picture[i][j] != 0) {
                    isVisited[i][j] = true;
                    cnt = 1;
                    element = picture[i][j];
                    DFS(picture, i, j, element, m, n);
                    que.add(cnt);
                }
            }
        }
        PriorityQueue<Integer> reversedPriorityQueue =
                new PriorityQueue<Integer>(que.size(), Collections.reverseOrder());
        reversedPriorityQueue.addAll(que);

        numberOfArea = que.size();
        maxSizeOfOneArea = reversedPriorityQueue.peek();

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void DFS(int[][] picture, int x, int y, int element, int m, int n) {
        if(!(x-1<0) && picture[x-1][y] == element && (!isVisited[x-1][y])) {
            isVisited[x-1][y] = true;
            cnt++;
            DFS(picture, x-1, y, element, m, n);
        }
        if(!(x+1 >= m) && picture[x+1][y] == element && !isVisited[x+1][y]) {
            isVisited[x+1][y] = true;
            cnt++;
            DFS(picture, x+1, y, element, m, n);
        }
        if(!(y-1<0) && picture[x][y-1] == element && !isVisited[x][y-1]) {
            isVisited[x][y-1] = true;
            cnt++;
            DFS(picture, x, y-1, element, m, n);
        }
        if(!(y+1 >= n) && picture[x][y+1] == element && !isVisited[x][y+1]) {
            isVisited[x][y+1] = true;
            cnt++;
            DFS(picture, x, y+1, element, m, n);
        }
    }
}
