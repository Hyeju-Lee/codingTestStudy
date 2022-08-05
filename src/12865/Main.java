import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] items = new int[n+1][2];
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (items[i][0] > j)
                    dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
