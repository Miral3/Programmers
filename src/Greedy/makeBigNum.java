package Greedy;

public class makeBigNum {
    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        System.out.println(solution(number, k));
    }
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char max;
        int idx = 0;

        if(number.charAt(0) == '0') {
            return "0";
        }

        for(int i  = 0; i < number.length()-k; i++) {
           max = '0';
            for(int j = idx; j <= k+i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j+1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}
