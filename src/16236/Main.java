import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish {
        int x;
        int y;
        int sharkSize;
        int eatCount;   //상어가 먹이 먹은 횟수
        int time;
        Fish(int x, int y, int sharkSize, int eatCount, int time) {
            this.x = x;
            this.y = y;
            this.sharkSize = sharkSize;
            this.eatCount = eatCount;
            this.time = time;
        }
    }
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static Queue<Fish> que = new LinkedList<>();
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        Fish shark = null;
        List<Fish> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Fish(i, j, 2, 0, 0);
                    map[i][j] = 0;
                    continue;
                }

                if (map[i][j] == 1) {//지금 먹을 수 있는 먹이가 있다면
                    list.add(new Fish(i,j,0,0,0));
                    //초기 상태에서 먹을 수 있는 먹이가 있는지 확인하는 용도
                }
            }
        }

        if (list.isEmpty()) {
            System.out.print(0);
            return;
        }

        PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if (o1.time == o2.time) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    else return o1.x - o2.x;
                }
                else return o1.time - o2.time;
            }
        });

        que.offer(shark);

        while (true) {   //엄마 부를때까지 반복
            visited = new boolean[n][n];
            visited[que.peek().x][que.peek().y] = true;
            while (!que.isEmpty()) {
                Fish now = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n
                            || visited[nx][ny] || map[nx][ny] > now.sharkSize) continue;
                    if (map[nx][ny] < now.sharkSize && map[nx][ny] != 0) {
                        pq.offer(new Fish(nx, ny, now.sharkSize, now.eatCount+1,
                                now.time + 1)); //이동 횟수와 먹이 먹은 횟수 증가
                    }

                    que.offer(new Fish(nx,ny,now.sharkSize, now.eatCount,
                            now.time+1));
                    visited[nx][ny] = true;
                }
            }
            if (pq.isEmpty()) {
                System.out.print(result);
                return;
            }

            Fish fish = pq.poll();
            if (fish.sharkSize == fish.eatCount) {  //자신의 크기와 같은 개수의 먹이 먹으면 1 증가
                fish.sharkSize++;
                fish.eatCount = 0;
            }

            map[fish.x][fish.y] = 0;
            result += fish.time;
            que.offer(new Fish(fish.x, fish.y, fish.sharkSize, fish.eatCount, 0));
            pq.clear();
        }


    }

}
