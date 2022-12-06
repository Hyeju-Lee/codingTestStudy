import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r,c,n;
    static char[][] map;
    static Queue<int[]> que = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 2; i <= n; i++) {
            if (i % 2 ==1) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (map[j][k] == 'O') {
                            que.offer(new int[]{j,k});
                        }
                    }
                }
                for (char[] tmp : map) {
                    Arrays.fill(tmp, 'O');
                }
                while (!que.isEmpty()) {
                    int[] now = que.poll();
                    map[now[0]][now[1]] = '.';
                    for (int t = 0; t < 4; t++) {
                        int nx = now[0] + dx[t];
                        int ny = now[1] + dy[t];
                        if (nx >= 0 && nx < r && ny >= 0 && ny <c)
                            map[nx][ny] = '.';
                    }
                }
            }
        }

        if (n % 2 == 0) {
            for (char[] tmp : map)
                Arrays.fill(tmp, 'O');
        }

        printMap();
    }



    static void printMap() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}