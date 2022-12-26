import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Info {
    int num;
    int cnt;
    Info (int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        Queue<Info> que = new LinkedList<>();
        que.offer(new Info(n, 0));
        visited[n] = true;
        while (!que.isEmpty()) {
            Info now = que.poll();
            if (now.num == 1) {
                System.out.println(now.cnt);
                System.exit(0);
            }
            if (now.num % 3 == 0 && !visited[now.num / 3]) {
                visited[now.num / 3] = true;
                que.offer(new Info(now.num/3, now.cnt+1));
            }
            if (now.num % 2 == 0 && !visited[now.num / 2]) {
                visited[now.num/2] = true;
                que.offer(new Info(now.num / 2, now.cnt+1));
            }
            if (!visited[now.num - 1]) {
                visited[now.num - 1] = true;
                que.offer(new Info(now.num - 1, now.cnt+1));
            }
        }
    }
}