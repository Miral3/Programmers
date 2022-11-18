package ex17687;

/*
  문제 이름: n진수 게임
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/17687
  알고리즘: 구현, 문자열
  자료구조: 문자열
*/

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int n = 16;
        int t = 16;
        int m = 2;
        int p = 2;
        String result = solution.solution(n, t, m, p);
        System.out.println(result);
    }
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int lastIndex = m * (t - 1) + p;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            if (sb.length() >= lastIndex) {
                break;
            }
            String transformNum = Integer.toString(i, n).toUpperCase();
            sb.append(transformNum);
            i++;
        }
        String[] arr = sb.toString().split("");
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            if(result.length() == t) {
                break;
            }
            if (j % m == p - 1) {
                result.append(arr[j]);
            }
        }
        answer = result.toString();
        return answer;
    }
}
