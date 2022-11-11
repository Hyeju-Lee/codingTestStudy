
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (i == k-1) {
                max = sum;
            }
            if (i >= k) {
                sum -= arr[i-k];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);

    }
}