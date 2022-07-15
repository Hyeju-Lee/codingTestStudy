import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 2;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1)
                        arr[i][j] = 1;
                    else if (arr[i][k] == 2 && arr[k][j] == 2)
                        arr[i][j] = 2;
                }
            }
        }

        int cnt;
        for (int i = 1; i <= n; i++) {
            cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j && arr[i][j] == 0) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}