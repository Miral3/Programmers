package ex17683;

/*
  문제 이름: [3차] 방금그곡
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/17683?language=java#
  알고리즘: 구현
  자료구조: 배열 리스트
*/

import java.util.*;

class Music implements Comparable<Music> {
    int idx;
    String name;
    int size;

    public Music(int idx, String name, int size) {
        this.idx = idx;
        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(Music o) {
        int diff = o.size - size;
        if (diff == 0) {
            return idx - o.idx;
        }
        return diff;
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Music> list = new ArrayList<>();
        m = replace(m);
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            String[] startTime = info[0].split(":");
            int startHour = Integer.parseInt(startTime[0]);
            int startMinute = Integer.parseInt(startTime[1]);

            String[] endTime = info[1].split(":");
            int endHour = Integer.parseInt(endTime[0]);
            int endMinute = Integer.parseInt(endTime[1]);

            int size = (endHour - startHour) * 60 + (endMinute - startMinute);

            String name = info[2];
            String[] sheet = replace(info[3]).split("");

            int cnt = 0;
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while(cnt < size) {
                sb.append(sheet[idx]);
                idx = (idx + 1) % sheet.length;
                cnt++;
            }

            if (sb.toString().contains(m)) {
                list.add(new Music(i, name, size));
            }
        }

        if (list.size() == 0) {
            return "(None)";
        }

        Collections.sort(list);
        answer = list.get(0).name;
        return answer;
    }
    public static String replace(String str) {
        String[] arr = {"C#", "D#", "F#", "G#", "A#"};
        for (int i = 0; i < arr.length; i++) {
            str = str.replaceAll(arr[i], arr[i].substring(0, 1).toLowerCase());
        }
        return str;
    }
}
