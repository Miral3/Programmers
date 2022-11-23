package ex133499;

/*
  문제 이름: 옹알이 (2)
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/133499
  알고리즘: 구현
  자료구조: 문자열
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int result = solution.solution(babbling);
        System.out.println(result);
    }

    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            int idx = 0;
            int prev = -1;
            while (true) {
                boolean isFind = false;
                for (int j = 0; j < arr.length; j++) {
                    if (babbling[i].indexOf(arr[j], idx) == idx && j != prev) {
                        idx += arr[j].length();
                        prev = j;
                        isFind = true;
                        break;
                    }
                }
                if (!isFind) {
                    break;
                }
            }
            if (idx == babbling[i].length()) {
                answer++;
            }
        }
        return answer;
    }
}
