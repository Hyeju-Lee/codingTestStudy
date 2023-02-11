import java.util.*;
class LV2_6 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        if (cacheSize == 0) return cities.length * 5;
        for (int i = 0; i < cities.length; i++) {
            String now = cities[i].toLowerCase();
            if (que.size() < cacheSize && !que.contains(now)) {
                que.offer(now);
                answer += 5;
                continue;
            }
            if (que.contains(now)) {
                que.remove(now);
                que.offer(now);
                answer += 1;
            }
            else {
                que.poll();
                que.offer(now);
                answer += 5;
            }

        }
        return answer;
    }
}
