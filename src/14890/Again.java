import java.util.Scanner;

public class Again {
    static int n,l;
    static int cnt = 0;
    static int[][] map;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        map = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            checkRow(i);
            checkCol(i);
        }

        System.out.println(cnt);
    }

    static void checkRow(int s) {
        int[] visited = new int[n];
        int height = map[s][0];
        for (int i=1; i<n; i++) {
            //같은 높이
            if (map[s][i] ==  height) continue;
            //올라갈 때
            if (map[s][i] > height) {
                if (map[s][i] - 1 != height) return;
                for (int j=i-1; j>=i-l; j--) {
                    if (j<0) return;
                    if (map[s][j] != height) return;
                    if (visited[j] == 1) return;
                    visited[j] = 1;
                }
            }
            //내려갈 때
            else {
                if (map[s][i]+1 != height) return;
                for (int j=i; j<i+l; j++) {
                    if (j>=n) return;
                    if (map[s][j] != height-1) return;
                    if (visited[j] == 1) return;
                    visited[j] = 1;
                }
            }
            height = map[s][i];
        }
        cnt++;
    }

    static void checkCol(int s) {
        int[] visited = new int[n];
        int height = map[0][s];
        for (int i=1; i<n; i++) {
            //같은 높이
            if (map[i][s] ==  height) continue;
            //올라갈 때
            if (map[i][s] > height) {
                if (map[i][s] - 1 != height) return;
                for (int j=i-1; j>=i-l; j--) {
                    if (j<0) return;
                    if (map[j][s] != height) return;
                    if (visited[j] == 1) return;
                    visited[j] = 1;
                }
            }
            //내려갈 때
            else {
                if (map[i][s]+1 != height) return;
                for (int j=i; j<i+l; j++) {
                    if (j>=n) return;
                    if (map[j][s] != height-1) return;
                    if (visited[j] == 1) return;
                    visited[j] = 1;
                }
            }
            height = map[i][s];
        }

        cnt++;
    }
}
