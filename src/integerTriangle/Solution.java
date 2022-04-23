package integerTriangle;

/*
문제 이름: 정수 삼각형
링크: https://programmers.co.kr/learn/courses/30/lessons/43105?language=java
알고리즘: dp
자료구조: 배열
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = solution.solution(triangle);
        System.out.println(result);
    }

    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] += triangle[i][j] + dp[i-1][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] += triangle[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] += triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(dp[triangle.length-1][i], answer);
        }

        return answer;
    }
}
