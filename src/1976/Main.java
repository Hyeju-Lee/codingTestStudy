import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m;
    static ArrayList<Integer>[] graph;
    static int[] plan;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연결정보저장
        n = sc.nextInt();
        m = sc.nextInt();
        plan = new int[m];
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    graph[i].add(j);
                }
                if (i == j) graph[i].add(j);
            }
        }
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }
        for (int i = 0; i < m-1; i++) {
            bfs(plan[i], plan[i+1]);
        }
        System.out.println("YES");
        //bfs를 통해 que 빌 때까지 시작점에서 bfs 실행
        //다음 여행계획지에 도착하면 bfs return
        //큐 빌때까지 도착 못하면 no출력
        //다음 여행 계획지에 대해 bfs 실행
    }
    static void bfs(int start, int dest) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                if (next == dest) return;
                if (!visited[next]) {
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
        System.out.println("NO");
        System.exit(0);
    }
}