package findPrimeNumber;

/*
  문제 이름: 소수 찾기
  링크: https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
  알고리즘: 완전 탐색
  자료구조: 배열, 해시 셋
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int answer = 0;

    public static void main(String[] args) {
        Solution solution=new Solution();
        String numbers = "011";
        int result = solution.solution(numbers);
        System.out.println(result);
    }

    public int solution(String numbers) {
        int n = numbers.length();
        int[] arr = new int[n];
        int[] out = new int[n];
        boolean[] isVisited = new boolean[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        for (int i = 1; i <= n; i++) {
            backTracking(arr, out, isVisited, n, i, 0, set);
        }

        return answer;
    }

    public static void backTracking(int[] arr, int[] out, boolean[] isVisited, int n, int r, int depth, Set<Integer> set) {
        if (depth == r) {
            int sum = out[0];
            for (int i = 1; i < r; i++) {
                sum = sum * 10 + out[i];
            }

            if (set.contains(sum)) {
                return;
            }

            set.add(sum);

            if (isPrime(sum)) {
                answer++;
                return;
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                if (depth == 0 && arr[i] == 0) {
                    continue;
                }
                isVisited[i] = true;
                out[depth] = arr[i];
                backTracking(arr, out, isVisited, n, r, depth + 1, set);
                isVisited[i] = false;
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
