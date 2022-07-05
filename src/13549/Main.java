import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Loca {
    int location;
    int time;
    Loca (int location, int time) {
        this.location = location;
        this.time = time;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = Integer.MAX_VALUE;
        boolean[] visited = new boolean[100001];
        Queue<Loca> que = new LinkedList<>();
        que.offer(new Loca(n, 0));
        visited[n] = true;
        while (!que.isEmpty()) {
            Loca now = que.poll();
            if (now.location == k) {
                answer = Math.min(answer, now.time);
            }
            if (now.location * 2 <= 100000 && !visited[now.location * 2]) {
                que.offer(new Loca(now.location * 2, now.time));
                visited[now.location * 2] = true;
            }

            if (now.location - 1 >= 0 && !visited[now.location - 1]) {
                que.offer(new Loca(now.location - 1, now.time + 1));
                visited[now.location - 1] = true;
            }
            if (now.location + 1 <= 100000 && !visited[now.location + 1]) {
                que.offer(new Loca(now.location + 1, now.time + 1));
                visited[now.location + 1] = true;
            }

        }
        System.out.println(answer);
    }
}
