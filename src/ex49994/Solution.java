package ex49994;

/*
  문제 이름: 방문 길이
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/49994
  알고리즘: 구현
  자료구조: 해시 셋
*/

import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        int y = 0;
        int x = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int py = y;
            int px = x;
            boolean flag = true;
            switch (dir) {
                case 'U':
                    if (y == 5) {
                        flag = false;
                        continue;
                    }
                    y += 1;
                    break;
                case 'D':
                    if (y == -5) {
                        flag = false;
                        continue;
                    }
                    y -= 1;
                    break;
                case 'L':
                    if (x == -5) {
                        flag = false;
                        continue;
                    }
                    x -= 1;
                    break;
                case 'R':
                    if (x == 5) {
                        flag = false;
                        continue;
                    }
                    x += 1;
                    break;
                default :
                    break;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(y + "" + x + "" + py + "" + px);
            if (flag && !set.contains(sb.toString())) {
                StringBuilder rsb = new StringBuilder();
                rsb.append(py + "" + px + "" + y + "" + x);
                answer++;
                set.add(sb.toString());
                set.add(rsb.toString());
            }
        }
        return answer;
    }
}