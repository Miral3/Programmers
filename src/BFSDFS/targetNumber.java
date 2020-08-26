package BFSDFS;

public class targetNumber {
    static int answer;
    public static void main(String[] args) {
        int[] numbers = {1,1,1};
        int target = 1;

        System.out.println(solution(numbers, target));

    }
    public static int solution(int[] numbers, int target) {
        DFS(numbers, target,  0, 0);
        return answer;
    }
    public static void DFS(int[] numbers, int target, int sum, int idx) {
        if(idx == numbers.length) {
            if(sum == target) {
                answer++;
        }
            return ;
        }
        DFS(numbers, target, sum+numbers[idx], idx+1);
        DFS(numbers, target, sum-numbers[idx], idx+1);
    }
}
