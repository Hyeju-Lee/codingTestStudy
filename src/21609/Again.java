import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Group implements Comparable<Group> {
    int x;
    int y;
    int rainbow;
    int cnt;
    public Group(int x, int y, int rainbow, int cnt) {
        this.x = x;
        this.y = y;
        this.rainbow = rainbow;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Group group) {
        if (this.cnt == group.cnt) {
            if (this.rainbow == group.rainbow) {
                if (this.x == group.x) {
                    return group.y - this.y;
                }
                return group.x - this.x;
            }
            return group.rainbow - this.rainbow;
        }
        return group.cnt - this.cnt;
    }
}

public class Again {
    static int n,m;
    static int[][] map;
    static List<Group> groups = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (findGroup()) {
            Collections.sort(groups);
            remove();
            gravity();
            rotate();
            gravity();
        }

        System.out.print(answer);
    }

    static void rotate() {
        int[][] rotation = new int[n][n];
        for (int j = n-1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                rotation[(n-1)-j][i] = map[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            map[i] = rotation[i].clone();
        }
    }

    static void gravity() {
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (map[i][j] < 0) continue;
                int x = i;
                int nx = i+1;
                while (true) {
                    if (nx >= n || map[nx][j] != -2) break;
                    map[nx][j] = map[x][j];
                    map[x][j] = -2;
                    x = nx;
                    nx += 1;
                }
            }
        }
    }

    static void remove() {
        boolean[][] visited = new boolean[n][n];
        int x = groups.get(0).x;
        int y = groups.get(0).y;
        bfs(x, y, visited, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    map[i][j] = -2;
                }
            }
        }
        answer += Math.pow(groups.get(0).cnt, 2);

    }

    static boolean findGroup() {
        boolean[][] visited = new boolean[n][n];
        groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    bfs(i,j,visited, true);
                }
            }
        }

        if (!groups.isEmpty()) return true;
        return false;
    }

    static void bfs(int x, int y, boolean[][] visited, boolean flag) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x,y});
        visited[x][y] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int cnt = 1;
        int rainbow = 0;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (!visited[nx][ny]) {
                    if (map[x][y] == map[nx][ny] || map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        que.offer(new int[]{nx, ny});
                        cnt++;
                    }
                    if (map[nx][ny] == 0) rainbow++;
                }
            }
        }
        if (cnt >= 2) {
            groups.add(new Group(x,y,rainbow,cnt));
        }


        if (flag) {  //무지개 블록의 visited를 false로 바꿔 여러 그룹에 속할 수 있도록 함
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) visited[i][j] = false;
                }
            }
        }
    }
}