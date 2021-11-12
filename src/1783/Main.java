import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int result;
        if (n == 1)
            result = 1;
        else if (n == 2) {
            result = 1 + (m-1)/2;
            result = result > 4 ? 4 : result;
        }
        else if (m < 7) {
            result = m;
            result = result > 4 ? 4 : result;
        }
        else {
            result = 4 + m - 6;
        }

        System.out.println(result);
    }
}