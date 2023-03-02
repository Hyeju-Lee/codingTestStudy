import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] laser;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        laser = new int[n+1];
        dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        int i = 1;
        while (st.hasMoreTokens()) {
            laser[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        for (int j = 2; j <= n; j++) {
            if (laser[j-1] >= laser[j]) dp[j] = j-1;
            else {
                dp[j] = check(j-1, laser[j]);
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(dp[j+1] + " ");
        }
    }

    static int check(int idx, int cost) {
        if (laser[dp[idx]] >= cost || idx <= 1) {
            return dp[idx];
        }
        else {
            return check(dp[idx], cost);
        }
    }
}