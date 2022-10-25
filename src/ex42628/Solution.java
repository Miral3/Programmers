package ex42628;

/*
  문제 이름: 이중우선순위큐
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42628
  알고리즘: 구현
  자료구조: 우선순위 큐
*/

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        int[] result = solution.solution(operations);
        System.out.println(result);
    }
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pql = new PriorityQueue<>();
        PriorityQueue<Integer> pqh = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] arr = operation.split(" ");
            String Command = arr[0];
            int num = Integer.parseInt(arr[1]);

            switch (Command) {
                case "I" : {
                    pql.add(num);
                    pqh.add(num);
                    break;
                }
                case "D": {
                    if (num < 0) {
                        pql.poll();
                    } else {
                        pqh.poll();
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }

        int[] answer = new int[2];
        if (pql.peek() != pqh.peek()) {
            int pqhSize = pqh.size();
            int pqlSize = pql.size();

            for (int i = 0; i < pqhSize; i++) {
                int cur = pqh.poll();
                if (pql.contains(cur)) {
                    answer[0] = cur;
                    break;
                }
            }

            for (int i = 0; i < pqlSize; i++) {
                int cur = pql.poll();
                if (pqh.contains(cur)) {
                    answer[1] = cur;
                    break;
                }
            }
        }
        return answer;
    }
}
