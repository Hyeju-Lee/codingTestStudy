
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static boolean[][] adjacent;
    static int n;
    static int end;
    static int answer;
    static boolean flag;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        answer = 0;
        flag = false;
        n = sc.nextInt();
        int start = sc.nextInt();
        end = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n+1];
        adjacent = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjacent[a][b] = true;
            adjacent[b][a] = true;
        }
        dfs(0, start);
        if (flag) System.out.println(answer);
        else System.out.println(-1);
    }

    static void dfs(int depth, int start) {
        visited[start] = true;
        if (start == end) {
            flag = true;
            answer = depth;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && adjacent[i][start]) {
                dfs(depth+1, i);
            }
        }
    }

}