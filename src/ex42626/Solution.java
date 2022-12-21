package ex42626;

/*
  문제 이름: 더 맵게
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626
  알고리즘: 힙
  자료구조: 우선순위 큐
*/

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] scoville = {7, 7};
        int K = 7;
        int result = solution.solution(scoville, K);
        System.out.println(result);
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + second * 2;
            pq.add(mix);
            answer++;
        }

        if (pq.peek() < K) {
            answer = -1;
        }
        return answer;
    }
}
