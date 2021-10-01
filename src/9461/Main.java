import java.util.Scanner;

public class Main {
    static long[] dp;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            dp = new long[n+1];
            result(n);
            System.out.println(dp[n]);
        }
    }

    public static void result(int n) {
        for (int i = 1; i < 4 && i <= n; i++) {
            dp[i] = 1;
        }
        for (int i = 4; i < 6 && i <= n; i++) {
            dp[i] = 2;
        }
        for (int i = 6; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
    }
}
