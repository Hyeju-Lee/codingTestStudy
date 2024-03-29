import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (top <= stack.peek()[1]) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) System.out.print("0 ");
            stack.push(new int[]{i, top});
        }
    }
}