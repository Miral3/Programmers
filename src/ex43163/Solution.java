package ex43163;

/*
  문제 이름: 단어 변환
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/43163
  알고리즘: bfs
  자료구조: 큐, 배열 리스트
*/

import java.util.*;

class Node {
    int idx;
    int cnt;

    public Node(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
}
class Solution {
    static ArrayList<Integer> list[];
    static boolean[] isVisited;
    static int answer = 0;
    static String target;
    static String[] newWords;

    public int solution(String begin, String target, String[] words) {
        boolean isContain = false;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                isContain = true;
                break;
            }
        }
        if (!isContain) {
            return 0;
        }


        int n = words.length;
        isVisited = new boolean[n + 1];
        this.target = target;
        newWords = new String[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                newWords[i] = begin;
            } else {
                newWords[i] = words[i - 1];
            }
        }


        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n + 1; i++) {
            String cur = newWords[i];
            for (int j = i + 1; j < n + 1; j++) {
                String next = newWords[j];
                int cnt = 0;
                boolean canChange = true;
                for (int k = 0; k < cur.length(); k++) {
                    if (cur.charAt(k) != next.charAt(k)) {
                        if (cnt > 0) {
                            canChange = false;
                            break;
                        }
                        cnt++;
                    }
                }
                if (!canChange) {
                    continue;
                }
                list[i].add(j);
                list[j].add(i);
            }
        }

        bfs();
        return answer;
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        isVisited[0] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int idx = cur.idx;
            int cnt = cur.cnt;

            if (newWords[idx].equals(target)) {
                answer = cnt;
                return;
            }

            for (int i = 0; i < list[idx].size(); i++) {
                int next = list[idx].get(i);

                if (!isVisited[next]) {
                    que.add(new Node(next, cnt + 1));
                    isVisited[next] = true;
                }
            }
        }
    }
}