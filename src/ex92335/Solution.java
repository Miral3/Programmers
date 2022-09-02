package ex92335;

/*
  문제 이름: k진수에서 소수 개수 구하기
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/92335
  알고리즘: 구현, 수학
  자료구조: 문자열
*/

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String conversionN = conversion(n, k);
        String str = "";
        int start = 0;
        int length = conversionN.length();
        for (int i = 0; i < length; i++) {
            if (conversionN.charAt(i) != '0') {
                if (str.equals("")) {
                    start = i;
                }
                str += conversionN.charAt(i);
            }
            if (conversionN.charAt(i) == '0' || i == length - 1) {
                if (str.equals("")) {
                    continue;
                }
                if (!isPrime(Long.parseLong(str))) {
                    str = "";
                    continue;
                }

                if (start == 0 && i == length - 1) {
                    answer++;
                    str = "";
                } else if (start > 0 && conversionN.charAt(start - 1) == '0' && i == length - 1) {
                    answer++;
                    str = "";
                } else if (i < length - 1 && start == 0 && conversionN.charAt(i) == '0') {
                    answer++;
                    str = "";
                } else if (start > 0 && i < length - 1 && conversionN.charAt(start - 1) == '0' && conversionN.charAt(i) == '0') {
                    answer++;
                    str = "";
                }
            }
        }
        return answer;
    }

    public static String conversion(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n> 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }

    public static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

