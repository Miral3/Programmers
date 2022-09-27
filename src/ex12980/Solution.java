package ex12980;

/*
  문제 이름: 점프와 순간 이동
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12980
  알고리즘: 구현
  자료구조: 
*/

public class Solution {
    public int solution(int n) {
        int ans = 1;
        while(n != 1) {
            if (n % 2 != 0) {
                ans++;
            }
            n /= 2;
        }
        return ans;
    }
}
