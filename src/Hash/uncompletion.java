package Hash;
/*https://velog.io/@w-beom/Java-HashMap%EC%9D%98-getOfDefault-%EC%A4%91%EB%B3%B5-%EA%B0%AF%EC%88%98-%ED%99%95%EC%9D%B8*/
/*https://blog.naver.com/PostView.nhn?blogId=2zino&logNo=221452768472*/
import java.util.*;

public class uncompletion {
    public static void main(String[] args) {
        String[] particpant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(particpant, completion));

    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String key : participant) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                answer += key;
            }
        }
        return answer;
    }
}
