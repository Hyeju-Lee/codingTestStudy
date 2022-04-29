import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Group implements Comparable<Group> {
        int x;
        int y;
        int rainbowCnt;
        int totalCnt;
        Group (int x, int y, int rainbowCnt, int totalCnt) {
            this.x = x;
            this.y = y;
            this.rainbowCnt = rainbowCnt;
            this.totalCnt = totalCnt;
        }

        @Override
        public int compareTo(Group group) {
            if (this.totalCnt == group.totalCnt) {
                if (this.rainbowCnt == group.rainbowCnt) {
                    if (this.x == group.x) {
                        return group.y - this.y;
                    }
                    return group.x - this.x;
                }
                return group.rainbowCnt - this.rainbowCnt;
            }
            return group.totalCnt - this.totalCnt;
        }
    }
    static int n;
    static boolean visited[][];
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<Group> list;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (!findGroup()) break;
            gravity();
            rotation();
            gravity();
        }
        System.out.println(answer);
    }

    static boolean findGroup() {
        list = new ArrayList<>();
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    bfs(i, j, true);
                }
            }
        }
        visited = new boolean[n][n];
        if (list.isEmpty()) return false;
        else {
            Collections.sort(list);
            bfs(list.get(0).x, list.get(0).y, false);
            removeBlock();
        }
        return true;

    }

    static void removeBlock() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == true) {
                    count++;
                    map[i][j] = -2;
                }
            }
        }
        answer += (int)Math.pow(count, 2);
    }


    static void bfs(int x, int y, boolean flag) {
        int rainbow = 0;
        int total = 1;
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;
                if (map[nx][ny] == map[x][y] || map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    if (map[nx][ny] == 0) rainbow++;
                    total+=1;
                }
            }
        }
        if (total >= 2) list.add(new Group(x, y, rainbow, total));
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) visited[i][j] = false;
                }
            }
        }

    }

    public static void gravity() {
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 0) {
                    int nx = i;
                    while (true) {
                        nx += 1;
                        if (nx >= n || map[nx][j] != -2) break;
                    }
                    nx--;
                    if (nx != i) {
                        map[nx][j] = map[i][j];
                        map[i][j] = -2;
                    }
                }
            }
        }
    }


    public static void rotation() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[n-j-1][i] = map[i][j];
            }
        }
        map = tmp;
    }
}
