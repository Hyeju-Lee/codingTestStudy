import java.util.Scanner;

public class Main {
    static int n,m,h;
    static int[][] map;
    static int answer;
    static boolean isFinish = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        map = new int[h+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
            map[a][b+1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(0);
            if (isFinish) break;
        }
        if (isFinish) System.out.println(answer);
        else System.out.println(-1);
    }

    static void dfs(int depth) {
        if (depth == answer) {
            if (check()) isFinish = true;
            return;
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = 1;
                    map[i][j+1] = 2;

                    dfs(depth+1);

                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= n; i++) {
            int nx = i;
            int ny = 1;
            while (ny <= h) {
                if (map[ny][nx] == 1) nx++;
                else if (map[ny][nx] == 2) nx--;
                ny++;
            }
            if (nx != i) return false;
        }
        return true;
    }

}