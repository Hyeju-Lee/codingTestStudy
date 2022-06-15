import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[n+2];
            Point[] points = new Point[n+2];
            boolean[][] adjacent = new boolean[n+2][n+2];
            for (int i = 0; i < n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < n+1; i++) {
                for (int j = i+1; j < n+2; j++) {
                    int dist = Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y);
                    if (dist <= 1000) {
                        adjacent[i][j] = true;
                        adjacent[j][i] = true;
                    }
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            visited[0] = true;
            while (!queue.isEmpty()) {
                int k = queue.poll();
                for (int i = 0; i < n+2; i++) {
                    if (adjacent[k][i] && !visited[i]) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
            System.out.println(visited[n+1] ? "happy" : "sad");
        }


    }

}
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}