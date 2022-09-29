package ex87946;

/*
  문제 이름: 피로도
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946
  알고리즘: 순열
  자료구조: 배열
*/

class Solution {
    static int answer = 0;
    static int k;
    static int[] out;
    static int[][] dungeons;
    static boolean[] isVisited;

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        this.k = k;
        out = new int[n];
        this.dungeons = dungeons;
        isVisited = new boolean[n];
        permutation(0, n);
        return answer;
    }

    public static void permutation(int depth, int n) {
        if (depth == n) {
            int cnt = 0;
            int curFatigue = k;

            for (int i = 0; i < n; i++) {
                int idx = out[i];
                int minimum = dungeons[idx][0];
                int exhaustion = dungeons[idx][1];

                if (curFatigue >= minimum) {
                    curFatigue -= exhaustion;
                    cnt++;
                } else {
                    break;
                }
            }

            answer = Math.max(answer, cnt);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                out[depth] = i;
                permutation(depth + 1, n);
                isVisited[i] = false;
            }
        }
    }
}
