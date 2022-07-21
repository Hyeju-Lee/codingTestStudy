import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Num {
    int num;
    int cnt;
    Num(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}
public class Main {
    static int b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        b = sc.nextInt();
        bfs(a);
    }

    static void bfs(int start) {
        Queue<Num> que = new LinkedList<>();
        que.offer(new Num(start, 0));
        while (!que.isEmpty()) {
            Num now = que.poll();
            if (now.num == b) {
                System.out.println(now.cnt + 1);
                return;
            }
            if (now.num * 2 <= b)
                que.offer(new Num(now.num * 2, now.cnt + 1));
            String tmp = Integer.toString(now.num) + '1';
            try {
                if (Integer.parseInt(tmp) <= b)
                    que.offer(new Num(Integer.parseInt(tmp), now.cnt + 1));
            }catch (NumberFormatException e) {
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(-1);
    }
}
