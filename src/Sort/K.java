package Sort;
//K
import java.util.Arrays;

public class K {
    public static void main(String[] args) {
        int[] arr = {1,5,2,6,3,7,4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] returnArr;

        returnArr = solution(arr, commands);
        for(int i = 0; i < commands.length; i++){
            System.out.println(returnArr[i]);
        }
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            answer[i] = sort(array, commands[i][0], commands[i][1], commands[i][2]);
        }
        return answer;
    }
    public static int sort(int[] arr, int start, int end, int idx) {
        int length = end-start+1;
        int[] dummy = new int[length];
        for(int i = 0; i < length; i++) {
            dummy[i] = arr[start-1];
            start++;
        }
        Arrays.sort(dummy);
        return dummy[idx-1];
    }
}
