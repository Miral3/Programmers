package BruteForce;

import java.util.ArrayList;

public class praticeTest {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        int[] arr = solution(answers);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] solution(int[] answers) {
        int[] answer;
        int[] cntArr = new int[3];
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int max;
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < answers.length; i++) {
            if(i < 5) {
                if (first[i] == answers[i]) {
                    cntArr[0]++;
                }
                if (second[i] == answers[i]) {
                    cntArr[1]++;
                }
                if (third[i] == answers[i]) {
                    cntArr[2]++;
                }
            }
            else {
                if (first[i % 5] == answers[i]) {
                    cntArr[0]++;
                }
                if (second[i % 8] == answers[i]) {
                    cntArr[1]++;
                }
                if (third[i % 10] == answers[i]) {
                    cntArr[2]++;
                }
               }
        }

        max = cntArr[0];

        for(int i = 0; i< cntArr.length; i++) {
            if(max < cntArr[i]) {
                max = cntArr[i];
            }
        }

        for(int i = 0; i < cntArr.length; i++) {
            if(max == cntArr[i]) {
                list.add(i+1);
            }
        }
        answer = new int[list.size()];
        int idx = 0;
        for(int temp : list) {
            answer[idx++] = temp;
        }
        return answer;
    }
}
