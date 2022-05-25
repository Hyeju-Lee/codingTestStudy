import java.util.*;
class BFS_2 {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    public void bfs(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[x][i] == 1 && !visited[i] && x != i) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}