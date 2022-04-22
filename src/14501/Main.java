import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] t = new int[n+2];
        int[] p = new int[n+2];
        int[] dp = new int[n+2];
        int max = 0;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n+1; i++) {
            dp[i] = Math.max(dp[i], max);
            if (t[i]+i <= n+1) {
                dp[t[i] + i] = Math.max(dp[t[i]+i], dp[i]+p[i]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(dp[n+1]);
    }
}