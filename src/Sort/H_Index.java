package Sort;
//index
import java.util.Arrays;

public class H_Index {
    static int answer;
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1 ,5};
        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {
        answer = 0;
        sort(citations);
        return answer;
    }
    public static void sort(int[] citations) {
        int length = citations.length;
        int[] arr = new int[length+1];
        int idx = 0;

        for(int i = 0; i <= length; i++) {
            int cnt = 0;
            for(int j = 0; j < length; j++) {
                if(citations[j] >= i) {
                    cnt++;
                }
            }
            if(cnt >= i && length-cnt <= i) {
                arr[idx] = i;
                idx++;
            }
        }
        Arrays.sort(arr);
        answer = arr[length];
    }
}
