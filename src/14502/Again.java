import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Again {
    static int[][] map;
    static Queue<int[]> virus;
    static int cnt = 0;
    static int answer = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        virus = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    virus.add(new int[]{i,j});
                }
                else if (map[i][j] == 0) cnt++;
            }
        }
        dfs(0, n, m);
        System.out.println(answer-3);
    }

    static void dfs(int depth, int n, int m) {
        if (depth == 3) {
            answer = Math.max(answer,bfs(n, m));
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth+1, n, m);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int bfs(int n, int m) {
        Queue<int[]> que = new LinkedList<>(virus);
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int[][] cop = new int[n][m];
        for (int i=0; i<map.length; i++) {
            cop[i] = map[i].clone();
        }
        int ncnt = cnt;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if (cop[nx][ny] != 0) continue;
                cop[nx][ny] = 2;
                que.add(new int[]{nx, ny});
                ncnt--;
            }
        }
        return ncnt;
    }
}
