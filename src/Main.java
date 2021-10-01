import java.util.Scanner;

public class Main {
    static int[] dp;
    public  static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n+1];
        dp[0] = 1;
        if (n > 1 && n % 2 == 0) {
            dp[2] = 3;
            result(n);
        }
        System.out.println(dp[n]);
    }

    public static int result(int n) {
        if (dp[n] > 0) return dp[n];
        else if (n >= 4){
            dp[n] = result(n-2) * dp[2];
            for (int j = 4; j <= n; j+=2) {
                dp[n] += result(n-j) * 2;
            }
        }
        return dp[n];
    }
}