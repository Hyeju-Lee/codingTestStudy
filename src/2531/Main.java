import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int result = 0;
        int[] plate = new int[n];
        int[] eaten = new int[d+1];
        for (int i = 0; i < n; i++) {
            plate[i] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (eaten[plate[i]]++ == 0) cnt++;
        }
        for (int i = 0; i < n; i++) {
            if (result <= cnt) {
                if (eaten[c] == 0) result = cnt + 1;
                else result = cnt;
            }
            int j = (i + k) % n;
            if (eaten[plate[j]]++ == 0) cnt++;
            if (--eaten[plate[i]] == 0) cnt--;
        }
        System.out.println(result);
    }
}