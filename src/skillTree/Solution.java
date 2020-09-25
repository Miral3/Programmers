package skillTree;

public class Solution {
    public static void main(String[] args) {
        String skill = "ABC";
        String[] skill_trees = {"QWE"};
        System.out.println(solution(skill, skill_trees));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i = 0; i < skill_trees.length; i++) {
            int idx = 1;
            boolean isContain = false;
            for(int j = 0; j < skill_trees[i].length(); j++) {
                int idxOf = skill.indexOf(skill_trees[i].charAt(j));
                if(idxOf > -1) {
                    if(idxOf < idx) {
                        idx++;
                        isContain = true;
                    }
                    else {
                        isContain = false;
                        break;
                    }
                }
                else{
                    isContain = true;
                    continue;
                }
            }
            if(isContain) {
                answer++;
            }
        }
        return answer;
    }
}
