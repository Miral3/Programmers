package OneTwoThreeFour;

public class Solution {
    public static void main(String[] args) {
        int n = 60;
        System.out.println(solution(n));
    }
    public static String solution(int n) {
        String answer = "";
        String [] word = {"4", "1", "2"};
        int quotient = 0; // 몫
        int remainder = 0; // 나머지

        while(n > 0) {
            quotient = n/3;
            remainder = n%3;
            if(remainder == 0) {
                quotient -=1;
            }
            answer = word[remainder] + answer;
            n = quotient;
        }
        return answer;
    }
}
