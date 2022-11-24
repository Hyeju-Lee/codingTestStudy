import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] cow;
    static int n,k,r;
    static boolean[][] visited;
    static ArrayList<Node>[][] road;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        r = sc.nextInt();
        cow = new int[k][2];
        road = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                road[i][j] = new ArrayList<>();
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            int d = sc.nextInt()-1;
            road[a][b].add(new Node(c,d));
            road[c][d].add(new Node(a,b));
        }
        for (int i = 0; i < k; i++) {
            cow[i][0] = sc.nextInt()-1;
            cow[i][1] = sc.nextInt()-1;
        }
        for (int i = 0; i < k; i++) {
            bfs(cow[i][0], cow[i][1], i);
        }
        System.out.println(answer);
    }

    static void bfs(int x, int y, int idx) {
        visited = new boolean[n][n];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y));
        visited[x][y] = true;
        while (!que.isEmpty()) {
            Node now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                boolean flag = false;
                for (int j = 0; j < road[now.x][now.y].size(); j++) {
                    Node tmp = road[now.x][now.y].get(j);
                    if (nx == tmp.x && ny == tmp.y) {
                        flag = true;
                        break;
                    }
                }
                if (flag || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                que.offer(new Node(nx, ny));
            }
        }
        for (int i = idx; i < cow.length; i++) {
            if (!visited[cow[i][0]][cow[i][1]]) answer++;
        }
    }
}
