import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        boolean[] visited = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int num = queue.poll();
                if (num == K) {
                    System.out.println(count);
                    break;
                }
                if (num > 0 && !visited[num - 1]) {
                    queue.offer(num - 1);
                    visited[num - 1] = true;
                }

                if (num + 1 <= 100000 && !visited[num + 1]) {
                    queue.offer(num + 1);
                    visited[num + 1] = true;
                }
                if (num*2 <= 100000 && !visited[num * 2] ) {
                    queue.offer(num * 2);
                    visited[num * 2] = true;
                }
            }
            count++;
        }

    }
}