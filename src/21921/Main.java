import java.util.Scanner;

public class Main {
    static int n,x;
    static int[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        visit = new int[n];
        int answer = 0;
        int period = 0;
        for (int i = 0; i < n; i++) {
            visit[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i <n; i++) {
            sum += visit[i];
            if (i == x-1) {
                answer = sum;
                period = 1;
            }
            else if (i >= x) {
                sum -= visit[i-x];
                if (sum == answer) period++;
                else if (sum > answer) {
                    answer = sum;
                    period = 1;
                }
            }
        }
        if (answer == 0) {
            System.out.println("SAD");
            System.exit(0);
        }
        else System.out.println(answer + "\n" + period);
    }
}