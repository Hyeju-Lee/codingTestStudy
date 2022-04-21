import java.util.Scanner;

public class Main {
    static int n;
    static int result = 0;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] location = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                location[i][j] = scanner.nextInt();
            }
        }
        dfs(0, 5, location);
        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0}; //ud
    static int[] dy = {0, 0, -1, 1}; //lr

    public static void dfs(int index, int limit, int[][] location) {
        if (index == limit) { //5번 모두 탐색 완료한 경우
            int tmp = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp = Math.max(tmp, location[i][j]);
                }
            }

            result = Math.max(result, tmp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            boolean[][] isMerged = new boolean[n][n];
            int[][] now = new int[n][n];
            for (int p = 0; p < n; p++) {
                for (int j = 0; j < n; j++) {
                    now[p][j] = location[p][j];
                }
            }

            if (i == 0 || i == 2) { //위, 왼쪽
                for (int p = 0; p < n; p++) {
                    for (int j = 0; j < n; j++) {
                        move(now, isMerged, i, p, j);
                    }
                }
            } else if (i == 1 || i == 3) { //아래, 오른쪽
                for (int p = n - 1; p >= 0; p--) {
                    for (int j = n - 1; j >= 0; j--) {
                        move(now, isMerged, i, p, j);
                    }
                }
            }

            dfs(index + 1, limit, now);
        }

    }

    public static void move(int[][] location, boolean[][] isMerged, int i, int p, int j) {
        int ni = p;
        int nj = j;
        int moveRow = ni + dx[i];
        int moveCol = nj + dy[i];

        if (moveCol < 0 || moveRow < 0 || moveCol >= n || moveRow >= n) {
            return;
        }
        boolean end = false;
        while (!end) {
            if (location[moveRow][moveCol] == 0) {
                location[moveRow][moveCol] = location[ni][nj];
                location[ni][nj] = 0;
                ni = moveRow;
                nj = moveCol;
                moveRow = ni + dx[i];
                moveCol = nj + dy[i];
                if (moveCol < 0 || moveRow < 0 || moveCol >= n || moveRow >= n)
                    end = true;
            } else if (location[moveRow][moveCol] == location[ni][nj]) {
                if (!isMerged[moveRow][moveCol]) {
                    location[moveRow][moveCol] *= 2;
                    location[ni][nj] = 0;
                    isMerged[moveRow][moveCol] = true;
                }
                end = true;
            }
            else
                end = true;
        }

    }
}
