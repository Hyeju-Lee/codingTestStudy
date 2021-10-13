import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int arr[] = new int[n.length()];
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0';
            sum += n.charAt(i) - '0';
        }
        Arrays.sort(arr);

        if (sum % 3 == 0 && arr[0] == 0) {
            for (int i = n.length()-1; i >= 0; i--) {
                System.out.print(arr[i]);
            }
        }
        else {
            System.out.println(-1);
        }

    }
}
