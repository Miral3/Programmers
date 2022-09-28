package ex68936;

/*
  문제 이름: 쿼드압축 후 개수 세기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/68936
  알고리즘: 분할 정복, 재귀
  자료구조: 배열
*/

class Solution {
    static int[] answer;
    static int[][] arr;

    public int[] solution(int[][] arr) {
        this.arr = arr;
        answer = new int[2];
        dfs(0, 0, arr.length);
        return answer;
    }

    public static boolean isSameValue(int r, int c, int n) {
        int num = arr[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != num) {
                    return false;
                }
            }
        }

        answer[num]++;
        return true;
    }

    public static void dfs(int r, int c, int n) {
        if (isSameValue(r, c, n)) {
            return;
        }

        dfs(r, c, n / 2);
        dfs(r, c + (n/ 2), n / 2);
        dfs(r + (n/ 2), c, n / 2);
        dfs(r + (n/ 2), c + (n/ 2), n / 2);
    }
}
