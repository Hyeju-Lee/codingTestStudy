import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int n, k;
    static int[][] color;
    static int[][] horse;
    static Deque<Integer>[][] map;
    static int turn = 1;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        color = new int[n][n];
        horse = new int[k][3];
        map = new Deque[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                color[i][j] = sc.nextInt();
                map[i][j] = new ArrayDeque<>();
            }
        }
        for (int i = 0; i < k; i++) {
            horse[i][0] = sc.nextInt() - 1;
            horse[i][1] = sc.nextInt() - 1;
            horse[i][2] = sc.nextInt() - 1;
            map[horse[i][0]][horse[i][1]].add(i);
        }

        while (turn <= 1000) {
            for (int i = 0; i < k; i++) {
                int x = horse[i][0];
                int y = horse[i][1];
                int d = horse[i][2];
                if (map[x][y].getFirst() != i) continue;

                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || color[nx][ny] == 2) {
                    if (d == 0 || d == 2) d++;
                    else d--;
                    nx = x + dx[d];
                    ny = y + dy[d];
                    horse[i][2] = d;
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || color[nx][ny] == 2) continue;
                }
                move(x, y, nx, ny, color[nx][ny]);

                if (map[nx][ny].size() >= 4) {
                    System.out.println(turn);
                    return;
                }
            }
            turn++;
        }

        System.out.println(-1);

    }

    static void move(int x, int y, int nx, int ny, int color) {
        if (color == 0) {
            while (map[x][y].size() > 0) {
                int tmp = map[x][y].removeFirst();
                horse[tmp][0] = nx;
                horse[tmp][1] = ny;
                map[nx][ny].add(tmp);
            }
        } else if (color == 1) {
            while (map[x][y].size() > 0) {
                int tmp = map[x][y].removeLast();
                horse[tmp][0] = nx;
                horse[tmp][1] = ny;
                map[nx][ny].add(tmp);
            }
        }

    }
}