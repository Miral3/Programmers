package ex42579;

/*
  문제 이름: 베스트앨범
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42579
  알고리즘: 구현
  자료구조: 해시 맵, 배열 리스트
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Info implements Comparable<Info> {
    int idx;
    int plays;
    int sum;

    public Info(int idx, int plays, int sum) {
        this.idx = idx;
        this.plays = plays;
        this.sum = sum;
    }

    @Override
    public int compareTo(Info o) {
        int diff = o.plays - plays;
        if (diff == 0) {
            return idx - o.idx;
        }
        return diff;
    }
}

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
        int[] plays = {500, 600, 150, 800, 2500, 2000, 6000};
        int[] result = solution.solution(genres, plays);
        System.out.println(result);
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<Info>> map = new HashMap<>();
        int n = genres.length;
        for (int i = 0; i < n; i++) {
            ArrayList<Info> list = new ArrayList();
            int sum = plays[i];
            if (map.containsKey(genres[i])) {
                list = map.get(genres[i]);
                System.out.println();
                sum += list.get(list.size() - 1).sum;
            }
            list.add(new Info(i, plays[i], sum));
            map.put(genres[i], list);
        }
        List<Map.Entry<String, ArrayList<Info>>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o1, o2) -> o2.getValue().get(o2.getValue().size() - 1).sum - o1.getValue().get(o1.getValue().size() - 1).sum));
        for (Map.Entry<String, ArrayList<Info>> entry : entryList) {
            Collections.sort(entry.getValue());
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Info>> entry : entryList) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (i > 1) {
                    break;
                }
                result.add(entry.getValue().get(i).idx);
            }
        }
        int[] answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
