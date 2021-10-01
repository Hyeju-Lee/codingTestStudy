import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] arr = new String[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.next();
            arr[i][1] = scanner.next();
            arr[i][2] = scanner.next();
            arr[i][3] = scanner.next();
        }
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1].equals(e2[1])) {
                if (e1[2].equals(e2[2])) {
                    if (e1[3].equals(e2[3])) {
                        return e1[0].compareTo(e2[0]);
                    }
                    return Integer.parseInt(e2[3]) - Integer.parseInt(e1[3]);
                }
                return Integer.parseInt(e1[2]) - Integer.parseInt(e2[2]);
            }
            return Integer.parseInt(e2[1]) - Integer.parseInt(e1[1]);
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0]);
        }
    }
}