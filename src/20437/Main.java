import java.util.Scanner;

public class Main {
    static int max, min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            String str = sc.next();
            int[] alpha = new int[26];
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i) - 'a']++;
            }
            int k = sc.nextInt();
            if (k==1) {
                System.out.println("1 1");
                continue;
            }
            twoPointer(str, alpha, k);
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
                System.out.println(-1);
            }
            else System.out.println(min + " " + max);
        }
    }
    static void twoPointer(String str, int[] alpha, int k) {
        for (int i = 0; i < str.length() - k + 1; i++) {
            char now = str.charAt(i);
            if (alpha[now - 'a'] < k) continue;
            int cnt = 1;
            for (int j = i+1; j < str.length(); j++) {
                if (now == str.charAt(j)) cnt++;
                if (cnt == k) {
                    min = Math.min(min, j-i+1);
                    max = Math.max(max, j-i+1);
                    alpha[now - 'a']--;
                    break;
                }
            }
        }
    }
}