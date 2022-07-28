
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextLong());
        }
        long sum = 0;
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            sum += (a+b);
            pq.offer(a+b);
        }
        System.out.println(sum);

    }
}