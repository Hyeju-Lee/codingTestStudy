
import java.util.*;

public class Main {
    static int[] dice;
    static int nx,ny;
    static int n,m;
    static int[][] map;
    public static void main(String[] args) {
        dice = new int[7];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        nx = sc.nextInt();
        ny = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int dir = sc.nextInt();
            move(dir);
        }
    }

    static void copy() {
        if (map[nx][ny] == 0) map[nx][ny] = dice[6];
        else {
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }
    }
    static void move(int dir) {
        int[] tmp = dice.clone();
        switch (dir) {
            case 1:
                if (ny+1 >= m) break;
                ny++;
                dice[1] = tmp[4];
                dice[3] = tmp[1];
                dice[4] = tmp[6];
                dice[6] = tmp[3];
                copy();
                System.out.println(dice[1]);
                break;
            case 2:
                if (ny-1 < 0) break;
                ny--;
                dice[1] = tmp[3];
                dice[3] = tmp[6];
                dice[4] = tmp[1];
                dice[6] = tmp[4];
                copy();
                System.out.println(dice[1]);
                break;
            case 3:
                if (nx-1 < 0) break;
                nx--;
                dice[1] = tmp[5];
                dice[5] = tmp[6];
                dice[6] = tmp[2];
                dice[2] = tmp[1];
                copy();
                System.out.println(dice[1]);
                break;
            case 4:
                if (nx+1 >= n) break;
                nx++;
                dice[1] = tmp[2];
                dice[2] = tmp[6];
                dice[5] = tmp[1];
                dice[6] = tmp[5];
                copy();
                System.out.println(dice[1]);
                break;
        }
    }
}
