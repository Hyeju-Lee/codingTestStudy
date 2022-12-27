import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int cnt;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        cnt = 0;
        for (int i = 0; i < n; i++) {
            twoPointer(i);
        }
        System.out.println(cnt);
    }
    static void twoPointer(int num) {
        int left = 0;
        int right = n-1;
        while (true) {
            if (left == num) left++;
            else if (right == num) right--;

            if (left >= right) return;
            if (arr[left] + arr[right] < arr[num]) left++;
            else if (arr[left] + arr[right] > arr[num]) right--;
            else {
                cnt++;
                return;
            }
        }
    }
}