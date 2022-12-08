package ex42884;

/*
  문제 이름: 단속카메라
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42884
  알고리즘: 구현, 정렬
  자료구조: 배열
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int result = solution.solution(routes);
        System.out.println(result);
    }
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int prev = -30001;
        for (int i = 0; i < routes.length; i++) {
            if (prev < routes[i][0]) {
                answer++;
                prev = routes[i][1];
            }
        }
        return answer;
    }
}
