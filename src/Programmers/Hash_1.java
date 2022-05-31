import java.util.*;
class Hash_1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String player : participant) hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        for (String player : completion) hashMap.put(player, hashMap.get(player) - 1);

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}
