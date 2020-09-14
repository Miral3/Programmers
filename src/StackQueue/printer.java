package StackQueue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class printer {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> waitingList = new LinkedList<>();

        for(i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
        }

        for(i = 0; i < priorities.length; i++) {
            waitingList.add(i);
        }

        boolean check = false;
        int idx = 0;
        int[] arr = new int[priorities.length];
        while(!waitingList.isEmpty()) {
            int print = waitingList.poll();
            Iterator<Integer> keys = map.keySet().iterator();

            while(keys.hasNext()) {
                int key = keys.next();
                if(map.get(print) < map.get(key)) {
                    check = true;
                    break;
                }
            }
            if(check) {
                waitingList.add(print);
            }
            else{
                arr[idx++] = print;
                map.remove(print);
            }
            check = false;
        }
        for(i = 0; i < arr.length; i++) {
            if(arr[i] == location) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
