import java.util.Scanner;

public class Main {
    static int r,c,t;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int cleaner;
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] < 0 && cleaner == 0) {
                    cleaner = i;
                }
            }
        }
        while (t--> 0) {
            spread();
            operate();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer+2);

    }

    static void spread() {
        int[][] copy = new int[r][c];
        for (int i = 0; i < r; i++) {
            copy[i] = map[i].clone();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    count(i,j,copy);
                }
            }
        }
    }

    static void count(int x, int y, int[][] copy) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if (map[nx][ny] < 0) continue;
            map[nx][ny] += copy[x][y] / 5;
            cnt++;
        }
        map[x][y] -= cnt * (copy[x][y]/5);
        if (map[x][y] < 0) map[x][y] = 0;
    }

    static void operate() {
        int top = cleaner;
        int down = cleaner + 1;
        for (int i = top-1; i > 0; i--) {
            map[i][0] = map[i-1][0];
        }
        for (int j = 0; j < c-1; j++) {
            map[0][j] = map[0][j+1];
        }
        for (int i = 0; i < top; i++) {
            map[i][c-1] = map[i+1][c-1];
        }
        for (int j = c-1; j > 0; j--) {
            map[top][j] = map[top][j-1];
        }
        map[top][1] = 0;

        for (int i = down+1; i < r-1; i++) {
            map[i][0] = map[i+1][0];
        }
        for (int j = 0; j < c-1; j++) {
            map[r-1][j] = map[r-1][j+1];
        }
        for (int i = r-1; i > down; i--) {
            map[i][c-1] = map[i-1][c-1];
        }
        for (int j = c-1; j > 1; j--) {
            map[down][j] = map[down][j-1];
        }
        map[down][1] = 0;
    }


}