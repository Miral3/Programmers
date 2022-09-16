package ex76502;

/*
  문제 이름: 괄호 회전하기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502?language=java
  알고리즘: 구현
  자료구조: 스택
*/

import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        if (n % 2 == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (isCorrect(s, i, n)) {
                answer++;
            }
        }
        return answer;
    }
    public static boolean isCorrect(String str, int start, int n) {
        Stack<Character> storage = new Stack<>();

        for (int i = start; i < start + n; i++) {
            char cur = str.charAt(i % n);

            if (cur == ')' || cur == '}' || cur == ']') {
                if (storage.isEmpty()) {
                    return false;
                }
                if (cur == ')') {
                    if (storage.peek() == '(') {
                        storage.pop();
                    } else {
                        return false;
                    }
                }
                if (cur == '}') {
                    if (storage.peek() == '{') {
                        storage.pop();
                    } else {
                        return false;
                    }
                }
                if (cur == ']') {
                    if (storage.peek() == '[') {
                        storage.pop();
                    } else {
                        return false;
                    }
                }
            } else {
                storage.add(cur);
            }
        }

        return true;
    }
}