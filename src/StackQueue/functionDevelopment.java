package StackQueue;

import java.util.LinkedList;

public class functionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer;

        answer = solution(progresses, speeds);

        for(int i = 0; i < answer.length; i++) {
            if(answer[i] != 0) {
                System.out.print(answer[i]);
            }
        }
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        int[] answer = { };
        int complete;
        int idx;
        LinkedList<Integer> que = new LinkedList<>();
        LinkedList<Integer> que2 = new LinkedList<>();

        for(int i = 0; i < length; i++) {
            complete = 0;
            idx = 1;
            while(true) {
                complete = progresses[i] + (speeds[i] * idx);
                if(complete >= 100) {
                    break;
                }
                idx++;
            }
            que.add(idx);
        }

        while(!que.isEmpty()) {
            int rm = que.remove();
            int cnt = 1;
            if(que.isEmpty()) {
                que2.add(cnt);
            }
            while(!que.isEmpty()) {
                if(rm >= que.peek()) {
                    que.remove();
                    cnt++;
                    if(que.isEmpty()) {
                        que2.add(cnt);
                    }
                }
                else {
                    que2.add(cnt);
                    break;
                }
            }
        }
        answer = new int[que2.size()];

        idx = 0;
        while(!que2.isEmpty()) {
            answer[idx] = que2.remove();
            idx++;
        }
        return answer;
    }
}
