package ex43164;

/*
  문제 이름: 여행경로
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/43164
  알고리즘: dfs
  자료구조: 배열
*/

public class Solution {
    static String[] answer;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[] result = solution.solution(tickets);
        System.out.println(result);
    }
    public String[] solution(String[][] tickets) {
        int n = tickets.length + 1;
        answer = new String[n];
        isVisited = new boolean[n - 1];
        String[] out = new String[n];
        String start = "ICN";
        out[0] = start;

        dfs(1, n, out, tickets, start);

        return answer;
    }
    public static void dfs(int depth, int n, String[] out, String[][] tickets, String start) {
        if (depth == n) {
            if (answer[n - 1] == null) {
                answer = out.clone();
                return;
            }

            for (int i = 1; i < n; i++) {
                if (answer[i].compareTo(out[i]) < 0) {
                    return;
                }
                if (answer[i].compareTo(out[i]) > 0) {
                    answer = out.clone();
                    return;
                }
            }
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && tickets[i][0].equals(start)) {
                isVisited[i] = true;
                out[depth] = tickets[i][1];
                dfs(depth + 1, n, out, tickets, tickets[i][1]);
                isVisited[i] = false;
            }
        }
    }
}
