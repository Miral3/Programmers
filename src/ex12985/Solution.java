package ex12985;

/*
  문제 이름: 예상 대진표
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12985
  알고리즘: 구현
  자료구조:
*/

class Solution {
    static int answer;
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 8;
        int a = 1;
        int b = 4;
        int result = solution.solution(n, a, b);
        System.out.println(result);
    }
    public int solution(int n, int a, int b) {
        answer = 0;
        findMatchRound(n / 2, a, b, 1);
        return answer;
    }
    public static void findMatchRound(int half, int a, int b, int depth) {
        int na = (int)Math.ceil((double)a / 2);
        int nb = (int)Math.ceil((double)b / 2);
        if (na == nb) {
            answer = depth;
            return;
        }

        findMatchRound(half / 2, na, nb, depth + 1);
    }
}
