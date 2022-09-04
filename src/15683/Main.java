import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CCTV {
    int x;
    int y;
    int num;
    List<Integer> dirs = new ArrayList<>();

    CCTV(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    public void addDir(int dir) {
        dirs.add(dir);
    }
}
public class Main {
    static int[][] map;
    static int n,m;
    static List<CCTV> list;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int min = Integer.MAX_VALUE;
    static int area;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        list = new ArrayList<>();
        area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) area++;
                if (map[i][j] != 0 && map[i][j] != 6)
                    list.add(new CCTV(i,j,map[i][j]));
            }
        }
        dfs(0, new CCTV[list.size()]);
        System.out.println(min);

    }

    static void dfs(int depth, CCTV[] cctvs) {
        if (depth == list.size()) {
            countArea(cctvs, new boolean[n][m]);
            return;
        }
        CCTV selected = list.get(depth);
        for (int i = 0; i < 4; i++) {
            CCTV c = new CCTV(selected.x, selected.y, selected.num);
            switch (c.num) {
                case 1:
                    c.addDir(i);
                    cctvs[depth] = c;
                    dfs(depth+1, cctvs);
                    break;
                case 2:
                    if (i >= 2) return;
                    c.addDir(i);
                    c.addDir(i+2);
                    cctvs[depth] = c;
                    dfs(depth+1, cctvs);
                    break;
                case 3:
                    c.addDir(i);
                    c.addDir((i+1) % 4);
                    cctvs[depth] = c;
                    dfs(depth+1, cctvs);
                    break;
                case 4:
                    c.addDir(i);
                    c.addDir((i+1) % 4);
                    c.addDir((i+2) % 4);
                    cctvs[depth] = c;
                    dfs(depth+1, cctvs);
                    break;
                case 5:
                    if (i > 0) return;
                    c.addDir(i);
                    c.addDir((i+1) % 4);
                    c.addDir((i+2) % 4);
                    c.addDir((i+3) % 4);
                    cctvs[depth] = c;
                    dfs(depth+1, cctvs);
                    break;
            }
        }



    }

    static void countArea(CCTV[] cctvs, boolean[][] visited) {
        int cnt = 0;
        for (int i = 0; i < cctvs.length; i++) {
            CCTV c = cctvs[i];
            for (int j = 0; j < c.dirs.size(); j++) {
                int dir = c.dirs.get(j);
                int nx = c.x + dx[dir];
                int ny = c.y + dy[dir];
                while (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny]) {
                            cnt++;
                            visited[nx][ny] = true;
                        }
                    }
                    else if (map[nx][ny] == 6) break;
                    nx += dx[dir];
                    ny += dy[dir];
                }

            }
        }

        min = Math.min(min, area - cnt);
    }



