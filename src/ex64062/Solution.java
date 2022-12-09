package ex64062;

/*
  문제 이름: 징검다리 건너기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/64062
  알고리즘: 슬라이딩 윈도우
  자료구조: 연결 리스트, 덱
*/

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int result = solution.solution(stones, k);
        System.out.println(result);
    }
    public int solution(int[] stones, int k) {
        int answer = 200000001;
        int n = stones.length;
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            if (i >= k - 1) {
                answer = Math.min(answer, stones[deque.peek()]);
            }
        }
        return answer;
    }
}
