package StackQueue;

public class price {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] answerArr;

        answerArr = solution(prices);
        for(int i = 0; i < prices.length; i++) {
            System.out.print(answerArr[i]);
        }
    }
    public static int[] solution(int[] prices) {
        int length = prices.length;
        int answer[] = new int[length];

        for(int i = 0; i < length; i++) {
            for(int j = i+1; j < length; j++) {
                if(prices[i] <= prices[j]) {
                    answer[i]++;
                }
                else {
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
}
