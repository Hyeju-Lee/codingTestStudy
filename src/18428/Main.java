import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        dfs(0);
        System.out.println("NO");
    }
    static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(depth+1);
                    map[i][j] = 'X';
                }
            }
        }
    }
    static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        //char[][] copy = new char[n][n];
        boolean[][] check = new boolean[n][n];
        /*for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'T') {
                    que.offer(new int[]{i,j});
                }
            }
        }
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                while (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] != 'O') {
                        check[nx][ny] = true;
                        nx += dx[i];
                        ny += dy[i];
                    }
                    else break;
                }
            }
        }
        if (checkStudent(check)) {
            System.out.println("YES");
            System.exit(0);
        }

    }
    static boolean checkStudent(boolean[][] check) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'S') {
                    if (check[i][j])
                        return false;
                }
            }
        }
        return true;
    }
}