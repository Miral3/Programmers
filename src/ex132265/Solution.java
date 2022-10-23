package ex132265;

/*
  문제 이름: 롤케이크 자르기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/132265
  알고리즘: 구현
  자료구조: 해시 셋
*/

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int result = solution.solution(topping);
        System.out.println(result);
    }
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        int[] left = new int[n];
        HashSet<Integer> setL = new HashSet<>();
        int[] right = new int[n];
        HashSet<Integer> setR = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setL.add(topping[i]);
            setR.add(topping[n - 1 - i]);
            left[i] = setL.size();
            right[n - 1 - i] = setR.size();
        }

        for (int i = 0; i < n - 1; i++) {
            if (left[i] == right[i + 1]) {
                answer++;
            }
        }
        return answer;
    }
}
