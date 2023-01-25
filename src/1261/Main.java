import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Room implements Comparable<Room>{
    int x;
    int y;
    int breakCnt;
    Room (int x, int y, int breakCnt) {
        this.x = x;
        this.y = y;
        this.breakCnt = breakCnt;
    }
    public int compareTo(Room room) {
        if (this.breakCnt < room.breakCnt)
            return -1;
        return 1;
    }
}
public class Main {
    static int m,n;
    static int[][] room;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                room[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
    }
    static void bfs() {
        PriorityQueue<Room> pq = new PriorityQueue<>();
        pq.offer(new Room(0,0,0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            Room now = pq.poll();
            if (now.x == n-1 && now.y == m-1) {
                System.out.println(now.breakCnt);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (!visited[nx][ny] && room[nx][ny] == 1) {
                    pq.offer(new Room(nx,ny,now.breakCnt+1));
                    visited[nx][ny] = true;
                }
                else if (!visited[nx][ny] && room[nx][ny] == 0) {
                    pq.offer(new Room(nx,ny,now.breakCnt));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}