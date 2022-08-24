
import java.util.*;

class Location {
    int x;
    int y;
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static List<Location> snake;
    static int n;
    static int dirIdx;
    static char[] rotation = {'R', 'D', 'L', 'U'};
    static int nx,ny;
    static int time;
    static boolean flag;
    static int[][] map;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < k; i++) {
            map[sc.nextInt()-1][sc.nextInt()-1] = 1;
        }
        snake = new ArrayList<>();
        snake.add(new Location(0,0));
        dirIdx = 0;
        nx = 0;
        ny = 0;
        time = 0;
        flag = false;
        int l = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < l; i++) {
            int tmp = sc.nextInt();
            int t = tmp - cnt;
            cnt = tmp;
            char dir = sc.next().charAt(0);
            while (t--> 0) {
                move(rotation[dirIdx]);
                if (flag) {
                    System.out.println(time);
                    System.exit(0);
                }
            }
            if (dir == 'D') {
                if (dirIdx+1 > 3) dirIdx = -1;
                dirIdx++;
            }
            else if (dir == 'L') {
                if (dirIdx-1 < 0) dirIdx = 4;
                dirIdx--;
            }
        }
        while (!flag) {
            move(rotation[dirIdx]);
        }
        if (flag) {
            System.out.println(time);
        }
    }

    static void move(char dir) {
        switch (dir) {
            case 'L' :
                ny--;
                break;
            case 'R' :
                ny++;
                break;
            case 'U' :
                nx--;
                break;
            case 'D' :
                nx++;
                break;
        }
        time++;
        //벽 체크
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            flag = true;
            return;
        }
        //몸통 체크
        for (int i = 0; i < snake.size(); i++) {
            if (nx == snake.get(i).x && ny == snake.get(i).y) {
                flag = true;
                return;
            }
        }

        //사과 체크
        if (map[nx][ny] == 1) {
            map[nx][ny] = 0;
            snake.add(new Location(nx,ny));
        }
        else {
            snake.add(new Location(nx, ny));
            snake.remove(0);
        }

    }
}