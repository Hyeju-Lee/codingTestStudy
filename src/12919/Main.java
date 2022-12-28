import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        Queue<String> que = new LinkedList<>();
        que.offer(t);
        while (!que.isEmpty()) {
            String now = que.poll();
            if (now.equals(s)) {
                System.out.println(1);
                System.exit(0);
            }
            if (now.length() <= s.length()) continue;
            if (now.charAt(now.length()-1) == 'A') {
                que.offer(now.substring(0, now.length()-1));
            }
            if (now.charAt(0) == 'B') {
                StringBuffer sb = new StringBuffer(now.substring(1));
                String reverse = sb.reverse().toString();
                que.offer(reverse);
            }

        }
        System.out.println(0);
    }
}