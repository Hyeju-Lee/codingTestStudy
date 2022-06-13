import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(max, map[i][j]);
            }
        }

        int answer = 1;
        for (int i = 1; i < max; i++) {
            int tmp = 0;
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        bfs(j, k, i);
                        tmp++;
                    }
                }
            }
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
    static void bfs(int x, int y, int rain) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y));
        visited[x][y] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int a = node.x + dx[i];
                int b = node.y + dy[i];
                if (a < 0 || a >= n || b < 0 || b >= n) continue;
                if (map[a][b] > rain && !visited[a][b]) {
                    que.offer(new Node(a, b));
                    visited[a][b] = true;
                }
            }
        }

    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}