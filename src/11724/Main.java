import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] adjacent;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjacent = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adjacent[n1][n2] = true;
            adjacent[n2][n1] = true;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int v) {
        visited[v] = true;
        for (int i = 1; i <= n; i++) {
            if (adjacent[v][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}