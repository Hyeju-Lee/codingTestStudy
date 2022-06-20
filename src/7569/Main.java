import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static Queue<Tomato> queue;
    static int n, m, h;
    static int[][][] tomato;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        queue = new LinkedList();

        tomato = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0 ; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = sc.nextInt();
                    if (tomato[i][j][k] == 1)
                        queue.offer(new Tomato(j,k,i));
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int nz = t.z + dz[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h)
                    continue;
                if (tomato[nz][nx][ny] == 0) {
                    queue.offer(new Tomato(nx, ny, nz));
                    tomato[nz][nx][ny] = tomato[t.z][t.x][t.y] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] == 0) {
                        return -1;
                    }
                    result = Math.max(result, tomato[i][j][k]);
                }
            }
        }
        if (result == 1) return 0;
        else return result-1;
    }
}
class Tomato {
    int x;
    int y;
    int z;
    Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}