package Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Biggest {
    static String answer;
    public static void main(String[] args) {
        int[] num = {3, 30, 34, 5, 9};
        System.out.println(solution(num));
    }
    public static String solution(int[] numbers) {
        answer = " ";
        sort(numbers);
        return answer;
    }
    public static void sort(int[] num) {
    }
}
