package ex42746;

/*
  문제 이름: 가장 큰 수
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42746
  알고리즘: 구현
  자료구조: 배열, 문자열
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] numbers = {70,0,0,0,0};
        String result = solution.solution(numbers);
        System.out.println(result);
    }
    public String solution(int[] numbers) {
        String answer = "";
        int n = numbers.length;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strings, (s1, s2) -> {
            String p1 = padding(s1, 4);
            String p2 = padding(s2, 4);
            for (int i = 0; i < 4; i++) {
                if (p1.charAt(i) > p2.charAt(i)) {
                    return -1;
                } else if (p1.charAt(i) < p2.charAt(i)) {
                    return 1;
                }
            }
            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }

        answer = sb.toString();
        if (answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }

    public static String padding(String str, int n) {
        if (str.length() == n) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < n - str.length(); i++) {
            sb.append(str.charAt(i % str.length()));
        }
        return sb.toString();
    }
}
