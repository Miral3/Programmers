package ex42842;

/*
  문제 이름: 카펫
  링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842
  알고리즘: 구현
  자료구조: 배열
*/

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int brown = 10;
        int yellow = 2;
        int[] result = solution.solution(brown, yellow);
        System.out.println(result);
    }
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int row = 1;
        int column = 0;

        while(true) {
            column = sum / row;
            if(brown == row * 2 + (column - 2) * 2 &&
            yellow == (row - 2) * (column - 2)) {
                if (row >= column) {
                    answer[0] = row;
                    answer[1] = column;
                    break;
                }
            }
            row++;
        }
        return answer;
    }
}
