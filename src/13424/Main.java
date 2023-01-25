import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t--> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] road = new int[n+1][n+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == j) continue;
                    road[i][j] = 100000;
                }
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                road[a][b] = c;
                road[b][a] = c;
            }

            for (int  k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
                    }
                }
            }
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] friends = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }
            int tmp = Integer.MAX_VALUE;
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += road[friends[j]][i];
                }
                if (sum < tmp) {
                    answer = i;
                    tmp = sum;
                }
            }

            System.out.println(answer);


        }
    }
}