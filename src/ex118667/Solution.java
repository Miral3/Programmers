package ex118667;

/*
  문제 이름: 두 큐 합 같게 만들기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/118667
  알고리즘: 구현, 큐
  자료구조: 큐
*/


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        int result = solution.solution(queue1, queue2);
        System.out.println(result);
    }
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (Integer num : queue1) {
            sum1 += num;
            que1.add(num);
        }
        for (Integer num : queue2) {
            sum2 += num;
            que2.add(num);
        }

        while(true) {
            if (answer > 6000000) {
                return -1;
            }
            if (sum1 == sum2) {
                break;
            }
            if (sum1 > sum2) {
                if (que1.size() == 1) {
                    return -1;
                }
                int num = que1.poll();
                sum1 -= num;
                sum2 += num;
                que2.add(num);
            } else {
                if (que2.size() == 1) {
                    answer = -1;
                    break;
                }
                int num = que2.poll();
                sum1 += num;
                sum2 -= num;
                que1.add(num);
            }
            answer++;
        }
        return answer;
    }
}
