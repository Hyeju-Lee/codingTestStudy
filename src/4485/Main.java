import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;
    Node (int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    public int compareTo(Node node) {
        if (this.cost < node.cost)
            return -1;
        return 1;
    }
}
public class Main {
    static int n = 1;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while (n != 0) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) return;
            StringTokenizer st;
            map = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dijkstra();
            System.out.println("Problem " + idx + ": " + dist[n-1][n-1]);
            idx++;
        }



    }
    static void dijkstra() {
        dist[0][0] = map[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0,map[0][0]));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cost = now.cost;
            if (dist[now.x][now.y] < cost) continue;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                int ncost = dist[now.x][now.y] + map[nx][ny];
                if (ncost < dist[nx][ny]) {
                    dist[nx][ny] = ncost;
                    pq.offer(new Node(nx, ny, ncost));
                }
            }
        }
    }
}