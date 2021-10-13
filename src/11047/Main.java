import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        while (k != 0) {
            for (int i = n-1; i >= 0; i--) {
                if (arr[i] <= k) {
                    k = k - arr[i];
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}