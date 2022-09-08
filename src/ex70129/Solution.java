package ex70129;

/*
  문제 이름: 이진 변환 반복하기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=java
  알고리즘: 구현
  자료구조: 문자열
*/

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while (!s.equals("1")) {
            int prevLength = s.length();
            s = s.replaceAll("0", "");
            int nextLength = s.length();
            int removeZeroNum = prevLength - nextLength;
            s = Integer.toBinaryString(nextLength);

            answer[1] += removeZeroNum;
            answer[0]++;
        }
        return answer;
    }
}

