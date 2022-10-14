package ex131704;

/*
  문제 이름: 택배상자
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/131704
  알고리즘: 구현
  자료구조: 스택
*/

import java.util.Stack;

public class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (i == order[idx]) {
                answer++;
                idx++;
            } else {
                stack.add(i);
            }
            while (true) {
                if (!stack.isEmpty() && stack.peek() == order[idx]) {
                    answer++;
                    idx++;
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}
