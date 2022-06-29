package moreHot;

/*
  문제 이름: 더 맵
  링크: https://programmers.co.kr/learn/courses/30/lessons/42626
  알고리즘: 우선순위 큐
  자료구조: 우선순위 큐
*/

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int result = solution.solution(scoville, K);
        System.out.println(result);
    }

    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2) {
                count = -1;
                break;
            }
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + (second * 2);
            pq.add(sum);
            count++;
        }

        return count;
    }
}
