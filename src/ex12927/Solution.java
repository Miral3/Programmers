package ex12927;

/*
  문제 이름: 야근 지수
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12927
  알고리즘: 그리디
  자료구조: 배열
*/

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 3;
        int[] works = {1, 1};
        long result = solution.solution(n, works);
        System.out.println(result);
    }
    public long solution(int n, int[] works) {
        long answer = 0;
        int m = works.length;
        Arrays.sort(works);
        while (n > 0) {
            int max = works[m - 1];

            for (int i = m - 1; i >= 0; i--) {
                if (max <= works[i]) {
                    works[i]--;
                    n--;
                }
                if (n == 0) {
                    break;
                }
            }
        }

        for (int work : works) {
            if (work < 0) {
                return 0;
            }
            answer += (long)Math.pow(work, 2);
        }

        return answer;
    }
}
