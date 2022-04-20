import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Status {
        int ri;
        int rj;
        int bi;
        int bj;
        int cnt;
        String dir;
        Status (int ri, int rj, int bi, int bj, int cnt, String dir) {
            this.ri = ri;
            this.rj = rj;
            this.bi = bi;
            this.bj = bj;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] location = new char[n][m];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        String[] dir = {"L","R","U","D"};
        int rsi = 0;
        int rsj = 0;
        int bsi = 0;
        int bsj = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                location[i][j] = str.charAt(j);
                if (location[i][j] == 'R') {
                    rsi = i;
                    rsj = j;
                }
                if (location[i][j] == 'B') {
                    bsi = i;
                    bsj = j;
                }
            }
        }

        Queue<Status> queue = new LinkedList<>();
        queue.offer(new Status(rsi, rsj, bsi, bsj, 0, ""));
        boolean[][][][] visited = new boolean[n][m][n][m];
        visited[rsi][rsj][bsi][bsj] = true;

        while (!queue.isEmpty()) {
            Status s = queue.poll();
            if (s.cnt > 10) {
                System.out.println(-1);
                System.exit(0);
            }
            if (location[s.bi][s.bj] == 'O') {
                continue;
            }
            if (location[s.ri][s.rj] == 'O' && location[s.bi][s.bj] != 'O') {
                System.out.println(s.cnt);
                System.out.println(s.dir);
                System.exit(0);
            }

            for (int i = 0; i < dx.length; i++) {
                int rni = s.ri;
                int rnj = s.rj;
                while (true) {
                    if (rni + dx[i] >= 0 && rnj + dy[i] >= 0) {
                        rni += dx[i];
                        rnj += dy[i];
                        if (location[rni][rnj] == '#' || location[rni][rnj] == 'O') {
                            break;
                        }
                    }
                }
                if (location[rni][rnj] == '#') {
                    rni -= dx[i];
                    rnj -= dy[i];
                }

                int bni = s.bi;
                int bnj = s.bj;
                while (true) {
                    if (bni + dx[i] >= 0 && bnj + dy[i] >= 0) {
                        bni += dx[i];
                        bnj += dy[i];
                        if (location[bni][bnj] == '#' || location[bni][bnj] == 'O') break;
                    }
                }
                if (location[bni][bnj] == '#') {
                    bni -= dx[i];
                    bnj -= dy[i];
                }



                if (rni == bni && rnj == bnj && location[rni][rnj] != 'O') {  //B와 R이 같은 위치인 경우
                    int rDis = Math.abs(rni - s.ri) + Math.abs(rnj - s.rj);
                    int bDis = Math.abs(bni - s.bi) + Math.abs(bnj - s.bj);
                    if (rDis > bDis) {
                        rni -= dx[i];
                        rnj -= dy[i];
                    }
                    else {
                        bni -= dx[i];
                        bnj -= dy[i];
                    }
                }

                if (!visited[rni][rnj][bni][bnj]) {
                    visited[rni][rnj][bni][bnj] = true;
                    queue.offer(new Status(rni, rnj, bni, bnj, s.cnt+1, s.dir + dir[i]));
                }
            }
        }
        System.out.println(-1);
    }
}