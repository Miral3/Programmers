package ex42861;

/*
  문제 이름: 섬 연결하기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42861
  알고리즘: 그래프, 크루스칼
  자료구조: 배열
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1}, {2,3,8}};
        int result = solution.solution(n, costs);
        System.out.println(result);
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int weight = costs[i][2];

            if (!find(arr, a, b)) {
                answer += weight;
                unionParent(arr, a, b);;
            }
        }
        return answer;
    }

    public static int getParent(int[] arr, int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = getParent(arr, arr[x]);
    }

    public static void unionParent(int[] arr, int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);

        if (a < b) {
            arr[b] = a;
        } else {
            arr[a] = b;
        }
    }

    public static boolean find(int[] arr,  int a, int b) {
        a = getParent(arr, a);
        b = getParent(arr, b);
        if (a == b) {
            return true;
        }
        return false;
    }
}
