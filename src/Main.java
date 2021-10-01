import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[][] dp = new long[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int m = 0; m <= j; m++) {
                    dp[j][i] += dp[m][i-1] % 1000000000;
                }
            }
        }

        System.out.println(dp[n][k]%1000000000);
    }
}