import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        melt(map, 1);
    }

    static void melt(int[][] map, int year) {
        int[][] tmp = new int[n][m];
        if (Arrays.deepEquals(map, tmp)) {
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        if (i + dx[k] < 0 || i + dx[k] >= n || j + dy[k] < 0 || j + dy[k] >= m)
                            continue;
                        if (map[i + dx[k]][j + dy[k]] == 0)
                            cnt++;
                    }
                    tmp[i][j] = map[i][j] - cnt > 0 ? map[i][j] - cnt : 0;
                }
            }
        }
        visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (tmp[i][j] != 0 && !visited[i][j]) {
                    bfs(tmp, i, j);
                    count++;
                }
            }

        }

        if (count >= 2) System.out.println(year);
        else {
            melt(tmp, year+1);
        }
    }

    static void bfs(int[][] tmp, int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = point.i + dx[k];
                int y = point.j + dy[k];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (tmp[x][y] != 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new Point(x, y));
                }
            }
        }

    }


}
class Point {
    int i, j;
    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
