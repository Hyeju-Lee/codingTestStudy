import java.util.Scanner;

public class TwoDim_comb {
    static int[][] result;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //배열의 행
        int m = sc.nextInt(); //배열의 열
        int k = sc.nextInt(); //k개의 위치 뽑기
        result = new int[k][2];
        visited = new boolean[n][m];
        dfs(0, n,m,k, 0);
    }

    static void dfs(int depth, int n, int m, int k, int idx) {
        if (depth == k) {
            return;
        }
        for (int i = idx; i < n*m; i++) {
            int x = i/m;
            int y = i%m;
            if (!visited[x][y]) {
                visited[x][y] = true;
                result[depth][0] = x;
                result[depth][1] = y;
                dfs(depth+1, n, m, k, i+1);
                visited[x][y] = false;
            }
        }
    }
}
