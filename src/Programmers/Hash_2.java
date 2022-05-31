import java.util.*;
class Hash_2 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }
        return answer-1;
    }
}
