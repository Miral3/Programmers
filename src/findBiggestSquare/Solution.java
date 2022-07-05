package findBiggestSquare;

/*
  문제 이름: 가장 큰 정사각형 찾기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12905
  알고리즘: 다이나믹 프로그래밍
  자료구조: 배열
*/

public class Solution {
    static int[] dy = {-1, 0, -1};
    static int[] dx = {0, -1, -1};

    public static void main(String[] args) {
        Solution solution=new Solution();
        int [][]board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int result = solution.solution(board);
        System.out.println(result);
    }
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int max = 0;

        if (n < 2 || m < 2) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < 3; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];
                        min = Math.min(min, board[y][x]);
                    }
                    board[i][j] = min + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }

        answer = (int)Math.pow(max, 2);
        return answer;
    }
}
