import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int n,m;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = map[0][0];
        getCandy();
        System.out.println(dp[n-1][m-1]);
    }

    static void getCandy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i-1 >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j] + map[i][j], dp[i][j]);
                    if (j-1 >= 0)
                        dp[i][j] = Math.max(dp[i-1][j-1] + map[i][j], dp[i][j]);
                }
                if (j-1 >= 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + map[i][j]);
            }
        }
    }
}
