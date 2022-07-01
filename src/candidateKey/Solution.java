package candidateKey;

/*
문제 이름: 후보
링크: https://programmers.co.kr/learn/courses/30/lessons/42890?language=java
알고리즘: 조합
자료구조: 배열, 연결 리스트, 해시 셋
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    static List<String> candidateKey = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[][] relation = {{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}};
        int result = solution.solution(relation);
        System.out.println(result);
    }
    public int solution(String[][] relation) {
        int length = relation[0].length;

        for (int i = 1; i <= length; i++) {
            int[] out = new int[i];
            boolean[] isVisited = new boolean[length];
            combination(relation, out, isVisited, 0, length, 0, i);
        }

        minimality();
        return candidateKey.size();
    }

    public static void combination(String[][] relation, int[] out, boolean[] isVisited, int start, int n, int d, int r) {
        if (d == r) {
            String[] newDomain = new String[relation.length];
            for (int i = 0; i < relation.length; i++) {
                String sum = "";
                for (int j = 0; j < out.length; j++) {
                    sum += relation[i][out[j]];
                }
                newDomain[i] = sum;
            }

            if (isUniqueness(newDomain)) {
                String newCandidateKey = "";
                for (int i = 0; i < out.length; i++) {
                    newCandidateKey += Integer.toString(out[i]);
                }
                candidateKey.add(newCandidateKey);
            }

            return;
        }

        for (int i = start; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                out[d] = i;
                combination(relation, out, isVisited, i + 1, n , d + 1, r);
                isVisited[i] = false;
            }
        }
    }


    public static boolean isUniqueness(String[] arr) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));

        if (arr.length != set.size()) {
            return false;
        }

        return true;
    }

    public static void minimality() {
        for (int i = 0; i < candidateKey.size(); i++) {
            String current = candidateKey.get(i);
            for (int j = i + 1; j < candidateKey.size(); j++) {
                String next = candidateKey.get(j);
                if (current.length() == next.length()) {
                    continue;
                }

                int count = 0;
                for (int k = 0; k < current.length(); k++) {
                    String[] arr = current.split("");
                    if (next.contains(arr[k])) {
                        count++;
                    }
                    if (count == current.length()) {
                        --j;
                        candidateKey.remove(next);
                    }
                }
            }
        }
    }
}
