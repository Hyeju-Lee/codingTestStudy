import java.util.Scanner;

public class Main {
    static int dp[][];
    static int score[];
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        score = new int[n];
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
        }
        dp[0][0] = score[0];
        dp[0][1] = score[0];
        if(n>1) {
            dp[1][0] = score[1];
            dp[1][1] = score[0] + score[1];
        }
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-2][0],dp[i-2][1]) + score[i];
            dp[i][1] = dp[i-1][0] + score[i];
        }
        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
}
