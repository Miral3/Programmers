package ex17686;

/*
  문제 이름: 파일명 정렬
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/17686https://school.programmers.co.kr/learn/courses/30/lessons/17686
  알고리즘: 구현
  자료구조: 배열 리스트
*/

import java.util.*;

class File implements Comparable<File> {
    String fileName;
    String head;
    int number;

    public File(String fileName, String head, int number) {
        this.fileName = fileName;
        this.head = head;
        this.number = number;
    }

    @Override
    public int compareTo(File o) {
        int diff = this.head.compareTo(o.head);
        if (diff == 0) {
            return this.number - o.number;
        }
        return diff;
    }
}
class Solution {
    public String[] solution(String[] files) {
        String[] answer;
        ArrayList<File> list = new ArrayList<>();
        for (String file : files) {
            String type = "head";
            String head = "";
            int number = 0;
            for (char ch : file.toLowerCase().toCharArray()) {
                boolean isNum = false;
                if (ch - '0' >= 0 && ch - '0' < 10) {
                    isNum = true;
                }

                if (type == "head") {
                    if (isNum) {
                        type = "number";
                        number = (number * 10) + (ch - '0');
                        continue;
                    }
                    head += ch;
                }
                if (type == "number") {
                    if (!isNum) {
                        break;
                    }
                    number = (number * 10) + (ch - '0');
                }
            }
            list.add(new File(file, head, number));
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).fileName;
        }
        return answer;
    }
}
