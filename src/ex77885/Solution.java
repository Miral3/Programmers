package ex77885;

/*
  문제 이름: 2개 이하로 다른 비트
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=java
  알고리즘: 구현, 비트마스크
  자료구조: 배열
*/

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num + 1;
                continue;
            }

            String binary = Long.toBinaryString(num);
            StringBuilder sb = new StringBuilder(binary);
            int zeroIdx = binary.indexOf('0');

            if (zeroIdx == -1) {
                sb.insert(1, '0');
            } else {
                for (int j = binary.length() - 1; j >= 0; j--) {
                    if (binary.charAt(j) == '0') {
                        sb.setCharAt(j, '1');
                        sb.setCharAt(j + 1, '0');
                        break;
                    }
                }
            }
            answer[i] = Long.parseLong(sb.toString(), 2);
        }
        return answer;
    }
}

