package ex42577;

/*
  문제 이름: 전화번호 목록
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42577
  알고리즘: 구현
  자료구조: 해시셋
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] phone_book = {"3131341", "97", "1939"};
        boolean result = solution.solution(phone_book);
        System.out.println(result);
    }
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        for (int i = 0; i < phone_book.length; i++) {
            if (set.isEmpty()) {
                set.add(phone_book[i]);
                continue;
            }

            String str = "";
            for (int j = 0; j < phone_book[i].length(); j++) {
                str += phone_book[i].charAt(j);
                if (set.contains(str)) {
                    return false;
                }
            }

            set.add(phone_book[i]);
        }

        return true;
    }
}
