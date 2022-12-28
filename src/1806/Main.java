import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while (true) {
            if (sum >= s)
                sum -= arr[left++];
            else if (right >= n) break;
            else sum += arr[right++];

            if (sum >= s) {
                answer = Math.min(right-left, answer);
            }
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}
