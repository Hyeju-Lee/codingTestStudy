import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] ndx = {-1,-1,1,1};
    static int[] ndy = {-1,1,1,-1};
    static ArrayList<int[]> cloud;
    static int n;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        cloud = new ArrayList<>();
        cloud.add(new int[]{n-1, 0});
        cloud.add(new int[]{n-1, 1});
        cloud.add(new int[]{n-2, 0});
        cloud.add(new int[]{n-2, 1});

        for (int i = 0; i < m; i++) {
            int d = sc.nextInt();
            int s = sc.nextInt();
            visited = new boolean[n][n];
            moveCloud(d, s);
            int cloudSize = cloud.size();
            copy();
            makeCloud();
            for (int j = 0; j < cloudSize; j++) {
                cloud.remove(0);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0)
                    sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void makeCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2) {
                    if (!visited[i][j]) {
                        cloud.add(new int[]{i,j});
                        map[i][j] -= 2;
                    }
                }
            }
        }
    }
    static void copy() {
        for (int i = 0; i < cloud.size(); i++) {
            int x = cloud.get(i)[0];
            int y = cloud.get(i)[1];
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + ndx[j];
                int ny = y + ndy[j];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] > 0) cnt++;
            }
            map[x][y] += cnt;
        }
    }
    static void moveCloud(int d, int s) {
        for (int j = 0; j < cloud.size(); j++) {
            int nx = cloud.get(j)[0];
            int ny = cloud.get(j)[1];
            for (int i = 0; i < s; i++) {
                nx += dx[d-1];
                ny += dy[d-1];
                if (nx < 0) nx = n + nx;
                else if (nx >= n) nx = nx - n;
                if (ny < 0) ny = n + ny;
                else if (ny >= n) ny = ny - n;
            }

            cloud.set(j, new int[]{nx, ny});
            map[nx][ny]++;
            visited[nx][ny] = true;
        }
    }
}
