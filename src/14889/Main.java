import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] s;
    static int n;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        s = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int depth, int idx) {
        if (depth == n/2) { //팀 구성 완료
            count();
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    public static void count() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (visited[i]&& visited[j]) { //방문했다면 한 팀
                    start += s[i][j];
                    start += s[j][i];
                }
                else if (!visited[i] && !visited[j]) {
                    link += s[i][j];
                    link += s[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }
        min = Math.min(min, diff);
    }



}