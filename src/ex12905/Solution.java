package ex12905;

/*
  문제 이름: 가장 큰 정사각형 찾기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12905
  알고리즘: 다이나믹 프로그래밍
  자료구조: 배열
*/

class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;

        if (r < 2 || c < 2) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] == 1) {
                        return 1;
                    }
                }
            }
            return 0;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (board[i][j] > 0) {
                    int min = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1]));
                    board[i][j] = min + 1;
                    answer = Math.max(board[i][j], answer);
                }
            }
        }
        answer = (int)Math.pow(answer, 2);
        return answer;
    }
}
