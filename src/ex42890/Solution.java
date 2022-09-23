package ex42890;

/*
  문제 이름: 후보키
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42890
  알고리즘: 구현, 조합
  자료구조: 배열 리스트
*/

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    static String[][] relation;
    static ArrayList<String> result = new ArrayList<>();
    static ArrayList<String> uniqueness = new ArrayList<>();
    static ArrayList<String> candidateKey = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[][] relation = {{"a","1","aaa","c","ng"},{"a","1","bbb","e","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}};
        int result = solution.solution(relation);
        System.out.println(result);
    }
    public int solution(String[][] relation) {
        this.relation = relation;
        int answer = 0;
        int n = relation[0].length;
        char[] arr = new char[n];
        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (char)(i + '0');
        }
        for (int i = 1; i <= n; i++) {
            combination(arr, isVisited, 0, n, i);
        }
        checkUniqueness();
        checkMinimality();
        answer = candidateKey.size();
        return answer;
    }
    public static void combination(char[] arr, boolean[] isVisited, int start, int n, int r) {
        if (r == 0) {
            String val = "";
            for (int i = 0; i < n; i++) {
                if (isVisited[i]) {
                    val += arr[i];
                }
            }
            result.add(val);
            return;
        }

        for (int i = start; i < n; i++) {
            isVisited[i] = true;
            combination(arr, isVisited, i + 1, n, r-1);
            isVisited[i] = false;
        }
    }
    public static void checkUniqueness() {
        int n = result.size();
        for (int i = 0; i < n; i++) {
            String cur = result.get(i);
            char[] arr = cur.toCharArray();
            int m = relation.length;
            HashSet<String> set = new HashSet<>();
            boolean flag = true;

            for (int j = 0; j < m; j++) {
                String val = "";

                for (int k = 0; k < arr.length; k++) {
                    int num = arr[k] - '0';
                    val += relation[j][num];
                }

                if (set.contains(val)) {
                    flag = false;
                    break;
                }

                set.add(val);
            }
            if (!flag) {
                continue;
            }
            uniqueness.add(cur);
        }
        System.out.println();
    }
    public static void checkMinimality() {
        for (String key : uniqueness) {
            result.clear();
            int n = key.length();
            boolean[] isVisited = new boolean[n];
            char[] arr = key.toCharArray();
            boolean isMinimality = true;
            for (int i = 1; i < n; i++) {
                combination(arr, isVisited, 0, n, i);
                for (int j = 0; j < result.size(); j++) {
                    if (uniqueness.contains(result.get(j))) {
                        isMinimality = false;
                        break;
                    }
                }
                if(!isMinimality) {
                    break;
                }
            }

            if(isMinimality) {
                candidateKey.add(key);
            }
        }
    }
}
