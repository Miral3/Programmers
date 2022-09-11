package ex12981;

/*
  문제 이름: 영어 끝말잇기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12981?language=java
  알고리즘: 구현
  자료구조: 문자열, HashSet
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = solution.solution(n, words);
        System.out.println(result);
    }
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i != 0) {
                String prev = words[i - 1];
                if (set.contains(word) || prev.charAt(prev.length() - 1) != word.charAt(0)) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }
            }
            set.add(word);
        }
        return answer;
    }
}

/*
8 / 3 = 2
8 % 3 = 2

4/2 = 2
4 % 2 = 0
*/
