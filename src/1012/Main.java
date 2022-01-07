import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] location;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int count;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++){
            count = 0;
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            location = new int[m+1][n+1];
            visited = new boolean[m+1][n+1];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                location[x][y] = 1;
            }

            for (int j = 0; j < m; j++) {
                for (int g = 0; g < n; g++) {
                    if (location[j][g] == 1 && !visited[j][g]) {
                        //bfs(j,g);
                        count++;
                        dfs(j,g);
                    }
                }
            }

            System.out.println(count);
        }

    }

    /*static void bfs(int j, int g) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(j, g));
        visited[j][g] = true;
        count++;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];
                if (x>=0 && y>=0 && location[x][y] == 1 && !visited[x][y]) {
                    queue.offer(new Point(x,y));
                    visited[x][y] = true;
                }
            }
        }
    }*/

    static void dfs(int j, int g) {
        visited[j][g] = true;
        for (int i = 0; i < 4; i++) {
            int x = j + dx[i];
            int y = g + dy[i];
            if (x>=0 && y>=0 && location[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                dfs(x,y);
            }
        }
    }

    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}