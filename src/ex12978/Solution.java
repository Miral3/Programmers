package ex12978;

/*
  문제 이름: 배달
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/12978
  알고리즘: 다익스트라
  자료구조: 배열 리스트
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node (int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

class Solution {
    static int N;
    static int K;
    static List<Node>[] list;
    static int[] dist;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Solution solution=new Solution();
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;
        int result = solution.solution(N, road, K);
        System.out.println(result);
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        this.N = N;
        this.K = K;
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int weight = road[i][2];
            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int end = cur.end;

            if (isVisited[end]) {
                continue;
            }
            isVisited[end] = true;

            for (Node node : list[end]) {
                if (dist[node.end] > dist[end] + node.weight) {
                    dist[node.end] = dist[end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}
