import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int G;
    static int S;
    static int U;
    static int D;
    static int F;
    static boolean[] visited;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        visited = new boolean[F+1];
        bfs();
    }

    static void bfs() {
        Queue<Location> que = new LinkedList<>();
        que.offer(new Location(S, 0));
        visited[S] = true;
        while (!que.isEmpty()) {
            Location now = que.poll();
            if (now.location == G) {
                System.out.println(now.cnt);
                return;
            }
            if (now.location + U <= F && !visited[now.location + U]) {
                que.offer(new Location(now.location + U, now.cnt+1));
                visited[now.location + U] = true;
            }
            if (now.location - D > 0 && !visited[now.location - D]) {
                que.offer(new Location(now.location - D, now.cnt+1));
                visited[now.location - D] = true;
            }
        }
        System.out.println("use the stairs");
    }

}

class Location {
    int location;
    int cnt;
    public Location(int location, int cnt) {
        this.location = location;
        this.cnt = cnt;
    }
}
