import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    int x;
    int y;
    int cnt;
    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point point) {
        if (this.cnt < point.cnt)
            return -1;
        return 1;
    }
}
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0, 0);
    }

    static void bfs(int x, int y, int cnt) {
        PriorityQueue<Point> que = new PriorityQueue<>();
        que.offer(new Point(x,y,cnt));
        visited[x][y] = true;
        while (!que.isEmpty()) {
            Point now = que.poll();
            if (now.x == n-1 && now.y == n-1) {
                System.out.println(now.cnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.offer(new Point(nx, ny, now.cnt+1));
                }
                else if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.offer(new Point(nx,ny,now.cnt));
                }
            }
        }
    }
}
