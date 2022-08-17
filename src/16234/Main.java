
import java.util.*;

class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,l,r;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        boolean flag;
        int day = 0;
        do {
            flag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i,j);
                        if (list.size() > 1) {
                            for (int k = 0; k < list.size(); k++) {
                                map[list.get(k).x][list.get(k).y] =
                                        people / list.size();
                            }
                            flag = true;
                        }
                    }
                }
            }
            if (flag) day++;
        } while (flag);

        System.out.println(day);

    }

    static int people;
    static List<Node> list;
    static void bfs(int i, int j) {
        list = new ArrayList<>();
        people = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(i, j));
        visited[i][j] = true;
        people += map[i][j];
        list.add(new Node(i,j));
        while (!que.isEmpty()) {
            Node now = que.poll();
            for (int k = 0; k < 4; k++) {
                int x = now.x + dx[k];
                int y = now.y + dy[k];
                if (x >= n || y >= n || x < 0 || y < 0) {
                    continue;
                }
                int gap = Math.abs(map[now.x][now.y] - map[x][y]);
                if (!visited[x][y] && gap >= l && gap <= r) {
                    que.offer(new Node(x,y));
                    visited[x][y] = true;
                    people += map[x][y];
                    list.add(new Node(x,y));
                }
            }
        }
    }
}
