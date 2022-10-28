package ex133501;

/*
  문제 이름: 야간 전술보행
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/133501
  알고리즘: 구현
  자료구조: 배열 리스트
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {
    int left;
    int right;
    int start;
    int end;

    public Node(int left, int right, int start, int end) {
        this.left = left;
        this.right = right;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        return left - o.left;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int distance = 12;
        int[][] scope = {{7, 8}, {4, 6}, {11, 10}};
        int[][] times = {{2, 2}, {2, 4}, {3, 3}};
        int result = solution.solution(distance, scope, times);
        System.out.println(result);
    }
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = distance;
        int n = scope.length;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = Math.min(scope[i][0],scope[i][1]);
            int right = Math.max(scope[i][0],scope[i][1]);
            int start = times[i][0];
            int end = times[i][1];

            list.add(new Node(left, right, start, end));
        }

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            Node cur = list.get(i);
            int left = cur.left;
            int right = cur.right;
            int start = cur.start;
            int end = cur.end;
            int time = cur.start + cur.end;
            int div = left / time;
            int cnt = div == 0 ? 0 : end - 1;
            boolean isWork = div == 0;

            int idx = div == 0 ? 1 : time * div;
            for (int j = idx; j <= right; j++) {
                cnt++;
                if (isWork) {
                    if (j >= left && j <= right) {
                        return j;
                    }
                    if (cnt == start) {
                        isWork = false;
                        cnt = 0;
                    }
                } else {
                    if (cnt == end) {
                        isWork = true;
                        cnt = 0;
                    }
                }
            }
        }

        return answer;
    }
}
