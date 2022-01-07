import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        int[][] location = new int[n][m];
        Queue<Tomato> queue = new LinkedList<>();
        int count = 0;
        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                location[i][j] = scanner.nextInt();
                if (location[i][j] == 1)
                    queue.offer(new Tomato(i,j,0));
                else if (location[i][j] == 0)
                    count++;
            }
        }

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            day = tomato.day;

            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if (nx >= 0 && nx < m && ny < n && ny >= 0) {
                    if (location[ny][nx] == 0) {
                        count--;
                        location[ny][nx] = 1;
                        queue.offer(new Tomato(ny, nx, day+1));
                    }
                }
            }
        }

        System.out.println(count == 0 ? day : -1);
    }

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int y, int x, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}