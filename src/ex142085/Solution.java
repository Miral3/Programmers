package ex142085;

/*
  문제 이름: 디펜스 게임
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/142085
  알고리즘: 그리디
  자료구조: 우선순위 큐
*/

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 2;
        int k = 4;
        int[] enemy = {3,3,3,3, 3};
        int result = solution.solution(n, k, enemy);
        System.out.println(result);
    }
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int m = enemy.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            pq.add(enemy[i]);
            k--;
            if (k < 0) {
                n -= pq.poll();
                k++;
                if (n < 0) {
                    answer = i;
                    break;
                }
            }
        }
        if (answer == 0) {
            answer = m;
        }
        return answer;
    }
}
