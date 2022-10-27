package ex42885;

/*
  문제 이름: 구명보트
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885
  알고리즘: 그리디
  자료구조: 배열
*/


import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        int result = solution.solution(people, limit);
        System.out.println(result);
    }
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        Arrays.sort(people);

        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = people[i];
            int min = people[idx];

            if (idx > i) {
                break;
            }

            if (cur + min <= limit) {
                answer++;
                idx++;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
