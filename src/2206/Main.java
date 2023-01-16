import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;
    int cnt;
    boolean broken;
    Node(int x, int y, int cnt, boolean broken) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.broken = broken;
    }

}
public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] =str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(answer);
    }


    static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0,0,1, false));
        visited[0][0][0] = true;
        while (!que.isEmpty()) {
            Node now = que.poll();
            if (now.x == n-1 && now.y == m-1) {
                answer = now.cnt;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 0) {  //벽이 아닌 경우
                    if (!now.broken && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        que.offer(new Node(nx,ny,now.cnt+1,false));
                    }
                    else if (now.broken && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        que.offer(new Node(nx,ny,now.cnt+1,true));
                    }
                }
                else if (map[nx][ny] == 1) {
                    if (!now.broken && !visited[nx][ny][1]) {
                        que.offer(new Node(nx,ny,now.cnt+1,true));
                        visited[nx][ny][1] = true;
                    }
                    //벽을 앞에서 부쉈다면 pass
                }
            }
        }
        answer = -1;

    }
}