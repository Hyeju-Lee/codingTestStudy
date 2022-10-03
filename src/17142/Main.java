import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Virus {
    int x;
    int y;
    int time;
    Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Main {
    static int n,m;
    static int[][] map;
    static List<Virus> viruses;
    static int emptySpace = 0;
    static Virus[] activate;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        activate = new Virus[m];
        viruses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    viruses.add(new Virus(i,j,0));
                }
                else if (map[i][j] == 0) {
                    emptySpace++;
                }
            }
        }
        if (emptySpace == 0) {
            System.out.println(0);
            System.exit(0);
        }

        dfs(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    public static void dfs(int depth, int idx) {
        if (depth == m) {
            bfs();
            return;
        }

        for (int i = idx; i < viruses.size(); i++) {
            activate[depth] = viruses.get(i);
            dfs(depth+1, i+1);
        }
    }

    public static void bfs() {
        int empty = emptySpace;
        Queue<Virus> que = new LinkedList<>();
        boolean[][] infected = new boolean[n][n];
        for (int i = 0; i < activate.length; i++) {
            Virus virus = activate[i];
            que.offer(virus);
            infected[virus.x][virus.y] = true;
        }
        while (!que.isEmpty()) {
            Virus now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (infected[nx][ny] || map[nx][ny] == 1) continue;
                if (map[nx][ny] == 0) empty--;
                if (empty == 0) {
                    answer = Math.min(answer, now.time + 1);
                    return;
                }
                que.offer(new Virus(nx, ny, now.time + 1));
                infected[nx][ny] = true;
            }
        }
    }
}
