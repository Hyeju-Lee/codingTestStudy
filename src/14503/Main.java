import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static Queue<Cleaner> que;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int result = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Cleaner start = new Cleaner(sc.nextInt(), sc.nextInt(), sc.nextInt());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n][m];
        result++;
        que  = new LinkedList<>();
        que.offer(start);
        visited[start.r][start.c]= true;
        bfs();
    }

    static void bfs() {
        while (!que.isEmpty()) {
            Cleaner now = que.poll();
            int cnt = 0;
            while (cnt < 4) {
                int left = (now.d + 3) % 4;
                int nr = now.r + dx[left];
                int nc = now.c + dy[left];
                if (map[nr][nc] == 0 && !visited[nr][nc]) {
                    que.offer(new Cleaner(nr, nc, left));
                    visited[nr][nc] = true;
                    result++;
                    break;
                }
                else {
                    now.d = left;
                }
                cnt++;
            }
            if (cnt == 4) {
                int back = (now.d+2) % 4;
                if (map[now.r + dx[back]][now.c + dy[back]] == 1)
                    break;
                else {
                    que.offer(new Cleaner(now.r + dx[back], now.c + dy[back], now.d));
                }
            }
        }
        System.out.println(result);

    }
}
class Cleaner {
    int r;
    int c;
    int d;
    public Cleaner(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
