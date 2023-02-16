import java.util.*;
class LV2_7 {
    HashMap<String, Integer> wish = new HashMap<>();
    HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < want.length; i++) {
            wish.put(want[i], number[i]);
        }
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i]))
                map.put(discount[i], map.get(discount[i]) + 1);
            else
                map.put(discount[i], 1);
        }

        if(check()) answer++;
        for (int i = 10; i < discount.length; i++) {
            map.put(discount[i-10], map.get(discount[i-10])-1);
            if (map.containsKey(discount[i]))
                map.put(discount[i], map.get(discount[i]) + 1);
            else
                map.put(discount[i], 1);
            if(check()) answer++;
        }

        return answer;
    }

    public boolean check() {
        for (String key : wish.keySet()) {
            if (map.get(key) != wish.get(key)) return false;
        }
        return true;
    }
}