package ex17679;

/*
  문제 이름: 프렌즈4블록
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/17679
  알고리즘: 구현
  자료구조: 배열, 문자열, 배열 리스트
*/

import java.util.ArrayList;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int result = solution.solution(m, n, board);
        System.out.println(result);
    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[] dy = {0, 1, 1};
        int[] dx = {1, 0, 1};
        String[][] map = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].split("")[j];
            }
        }
        while (true) {
            boolean isFind = false;
            ArrayList<Node> storage = new ArrayList<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j].equals("empty")) {
                        continue;
                    }
                    String cur = map[i][j];
                    boolean isSame = true;
                    for (int k = 0; k < 3; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (!cur.equals(map[ny][nx])) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        isFind = true;
                        storage.add(new Node(i, j));
                    }
                }
            }

            if (!isFind) {
                break;
            }

            for (int i = 0; i < storage.size(); i++) {
                Node position = storage.get(i);
                int y = position.y;
                int x = position.x;
                if (!map[y][x].equals("empty")) {
                    answer++;
                }
                map[y][x] = "empty";
                for (int j = 0; j < 3; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if (!map[ny][nx].equals("empty")) {
                        answer++;
                    }
                    map[ny][nx] = "empty";
                }
            }

            for (int i = 0; i < n; i++) {
                int emptyPosition = 0;
                for (int j = m - 1; j >= 0; j--) {
                    if (emptyPosition == 0 && map[j][i].equals("empty")) {
                        emptyPosition = j;
                        continue;
                    }

                    if (emptyPosition != 0 && !map[j][i].equals("empty")) {
                        String value = map[j][i];
                        map[j][i] = "empty";
                        map[emptyPosition][i] = value;
                        emptyPosition--;
                    }
                }
            }
        }
        return answer;
    }
}
