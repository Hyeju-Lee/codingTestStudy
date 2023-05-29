
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int idx = sc.nextInt();
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < w; i++) {
            int now = sc.nextInt();
            int cnt = 0;
            if (idx >= now) {   //현재 최대값보다 작으면 push
                while (!stack.isEmpty() && stack.peek() < now) {
                    int tmp = stack.pop();
                    answer += now - tmp;
                    cnt++;
                }
                while (cnt--> 0) {
                    stack.push(now);
                }
                stack.push(now);
            }
            else {
                while (!stack.isEmpty()) {
                    answer += idx - stack.pop();
                }
                idx = now;
            }

        }
        System.out.println(answer);
    }
}
