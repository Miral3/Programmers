package ex87390;

/*
  문제 이름: n^2 배열 자르기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/87390
  알고리즘: 구현
  자료구조: long
*/

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 4;
        long left = 7;
        long right = 14;
        int[] result = solution.solution(n, left, right);
        System.out.println(result);
    }
    public int[] solution(int n, long left, long right) {
        int[] answer;
        int size = (int)right - (int)left + 1;
        answer = new int[size];

        int idx = 0;
        for (long i = left; i <= right; i++) {
            int y = (int)(i / n) + 1;
            int x = (int)(i % n) + 1;
            if (y >= x) {
                answer[idx] = y;
            } else {
                answer[idx] = x;
            }

            idx++;
        }
        return answer;
    }
}
