package joystick;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String name = "LABLPAJM";
        int result = solution.solution(name);
        System.out.println(result);
    }

    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int min = length - 1;
        for (int i = 0; i < length; i++) {
                // 좌,우 이동
                int index = i + 1;
                while (index < length && name.charAt(index) == 'A') {
                    index++;
                }

                min = Math.min(min, Math.min((i * 2) + length - index, (length - index) * 2 + i));

                // 상,하 이동
                answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        answer += min;

        return answer;
    }
}
