import java.util.*;
class DFS_3 {
    int answer;
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        answer = 51;
        visited = new boolean[words.length];
        dfs(begin, 0, target, words);
        if(answer == 51) answer = 0;
        return answer;
    }
    public void dfs(String now, int depth, String target, String[] words) {
        if (now.equals(target))
            answer = Math.min(answer, depth);
        if (depth > words.length) return;
        for (int i = 0; i < words.length; i++) {
            int diff = 0;
            for (int j = 0; j < now.length(); j++) {
                if(now.charAt(j) != words[i].charAt(j))
                    diff++;
            }
            if(diff == 1 && !visited[i]) {
                visited[i] = true;
                dfs(words[i], depth+1, target, words);
            }
        }
    }
}