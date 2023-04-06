import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Again {
    static class Cleaner {
        int x;
        int y;
        int dir;
        int cnt;
        Cleaner(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0, 1, 0, -1}; //북, 동, 남, 서   
    static int n,m;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Cleaner> que = new LinkedList<>();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        que.offer(new Cleaner(r,c,d, 1));
        visited[r][c] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while(!que.isEmpty()) {
            Cleaner now = que.poll();
            int i;
            for (i = 0; i < 4; i++) {
                int dir = (4+ now.dir - (i+1)) % 4;
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    que.offer(new Cleaner(nx, ny, dir, now.cnt + 1));
                    visited[nx][ny] = true;
                    break;
                }
            }
            if (i == 4) {
                int nx = now.x + dx[(6+now.dir) % 4];
                int ny = now.y + dy[(6+now.dir) % 4];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    System.out.println(now.cnt);
                    return;
                }
                if (map[nx][ny] == 1) {
                    System.out.println(now.cnt);
                    return;
                }
                else {
                    que.offer(new Cleaner(nx, ny, now.dir, now.cnt));
                }
            }
        }



    }
}