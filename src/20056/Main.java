import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Main {
    static class FireBall {
        int r;
        int c;
        int m;
        int d;
        int s;
        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int n,m,k;
    static ArrayList<FireBall>[][] map;
    static ArrayList<FireBall> renew;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[n+1][n+1];
        ArrayList<FireBall> balls = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            FireBall tmp = new FireBall(x,y,
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            balls.add(tmp);
        }
        while (k-->0) {
            ArrayList<FireBall> t = move(balls);
            balls = t;
            visited = new boolean[n+1][n+1];
            renew = new ArrayList<>();
            for (int i = 0; i < balls.size(); i++) {
                FireBall now = balls.get(i);
                if (!visited[now.r][now.c] && map[now.r][now.c].size() >= 2) {
                    visited[now.r][now.c] = true;
                    sum(now.r, now.c);
                }
                else if (map[now.r][now.c].size() < 2){
                    renew.add(now);
                }
            }
            balls = renew;
        }

        int answer = 0;
        for (int i = 0; i < balls.size(); i++) {
            answer += balls.get(i).m;
        }
        System.out.print(answer);

    }

    static void sum(int x, int y) {
        ArrayList<FireBall> list = map[x][y];
        int sum_m = 0;
        int sum_s = 0;
        int fd = list.get(0).d % 2;
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            sum_m += list.get(i).m;
            sum_s += list.get(i).s;
            if (fd != list.get(i).d%2) flag = true;
        }
        int tmp = 0;
        if (flag) tmp = 1;
        if (sum_m/5 == 0) return;
        for (int i = 0; i < 7; i+=2) {
            renew.add(new FireBall(x, y, sum_m/5, sum_s/list.size(), tmp+i));
        }

    }

    static ArrayList<FireBall> move(ArrayList<FireBall> balls) {
        ArrayList<FireBall> result = new ArrayList<>();
        map = new ArrayList[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < balls.size(); i++){
            FireBall now = balls.get(i);
            int nx = now.r;
            int ny = now.c;
            int ns = now.s;
            while (ns-->0) {
                nx += dx[now.d];
                ny += dy[now.d];
                if (nx == 0) nx = n;
                if (ny == 0) ny = n;
                if (nx == n+1) nx = 1;
                if (ny == n+1) ny = 1;
            }

            result.add(new FireBall(nx,ny,now.m,now.s, now.d));
            map[nx][ny].add(new FireBall(nx,ny,now.m,now.s, now.d));
        }
        return result;
    }
}
