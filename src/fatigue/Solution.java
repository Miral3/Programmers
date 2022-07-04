package fatigue;

/*
  문제 이름: 피로도
  링크: https://programmers.co.kr/learn/courses/30/lessons/87946
  알고리즘: 순열
  자료구조: 배열, 배열 리스트
*/

import java.util.ArrayList;

public class Solution {
    static int max = -1;
    static int[] out;
    static boolean[] isVisited;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution=new Solution();
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int result = solution.solution(k, dungeons);
        System.out.println(result);
    }
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int n = dungeons.length;
        out = new int[n];
        isVisited = new boolean[n];

        permutation(0, n);
        getMaxAdventure(k, dungeons);

        answer = max;

        return answer;
    }
    public static void permutation(int depth, int n) {
        if (depth == n) {
            String sum = "";
            for (int i = 0; i < n; i++) {
                sum += out[i];
            }
            list.add(sum);
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
    public static void getMaxAdventure(int k, int[][] dungeons) {
        for (String str : list) {
            String[] arr = str.split("");
            int currentFatigue = k;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int idx = Integer.parseInt(arr[i]);
                int requiredFatigue = dungeons[idx][0];
                int exhaustionFatigue = dungeons[idx][1];
                if (currentFatigue < requiredFatigue) {
                    break;
                }
                count++;
                currentFatigue -= exhaustionFatigue;
            }
            max = Math.max(max, count);
        }
    }
}
