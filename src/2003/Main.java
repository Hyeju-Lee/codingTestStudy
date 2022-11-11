
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int left = 0;
        int right = 0;
        int cnt = 0;
        int sum = 0;
        while (true) {
            if (sum >= m) {
                sum -= arr[left++];
            }
            else if (right == n) break;
            else sum += arr[right++];
            if (sum == m) cnt++;
        }
        System.out.println(cnt);

    }
}