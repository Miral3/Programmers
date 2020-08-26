package BFSDFS;

import java.util.*;

public class Network {
    static boolean[] check;
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,1},{0,1,1}};
        System.out.println(solution(n, computers));
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1) {
                    graph.get(i+1).add(j+1);
                }
            }
        }

        check = new boolean[n+1];

        for(int i = 1; i < n+1; i++) {
            if(!check[i]) {
                BFS(graph, i);
                answer++;
            }
        }
        return answer;
    }
    public static void BFS(ArrayList<ArrayList<Integer>> graph, int idx) {
        LinkedList<Integer> que = new LinkedList<>();
        que.add(idx);

        while(!que.isEmpty()){
            int rm = que.remove();
            for(int nxtRm : graph.get(rm)) {
                if(!check[nxtRm]) {
                    check[nxtRm] = true;
                    que.add(nxtRm);
                }
            }
        }
    }
}
