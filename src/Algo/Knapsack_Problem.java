import java.util.Scanner;

public class Knapsack_Problem {
    static int n,k;
    static int[][] items;
    static int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        items = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            items[i][0] = sc.nextInt();
            items[i][1] = sc.nextInt();
        }
        max = 0;

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (items[i][0] > j) {   //현재 물건의 무게가 배낭에 들어갈 수 있는 무게보다 클 때
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
                }
            }
        }
    }
}
