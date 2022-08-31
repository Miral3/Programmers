package ex84512;

/*
  문제 이름: 모음사전
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/84512
  알고리즘: 조합
  자료구조: 배열 리스트
*/

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> list = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;
        combination(0, "");
        Collections.sort(list);
        answer = list.indexOf(word) + 1;
        return answer;
    }

    public static void combination(int depth, String str) {
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            list.add(str + arr[i]);
            combination(depth + 1, str + arr[i]);
        }
    }
}
