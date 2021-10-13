import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;

        while (n >= 2 && m >= 1) {
            n = n-2;
            m = m-1;
            if (n+m >= k)
                count++;
        }

        System.out.println(count);

    }
}
