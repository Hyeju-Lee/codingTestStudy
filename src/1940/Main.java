import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        int left = 0;
        int right = num.length-1;
        while (left < right) {
            if (num[left] + num[right] > m) {
                right--;
            }
            else if (num[left] + num[right] < m) {
                left++;
            }
            else {
                cnt++;
                left++;
            }
        }
        System.out.println(cnt);
    }
}