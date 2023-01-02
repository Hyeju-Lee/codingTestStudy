import java.util.Scanner;

public class Main {
    static int n,m,l,k;
    static int[][] star;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        k = sc.nextInt();
        int cnt;
        int answer = 0;
        star = new int[k][2];
        for (int i = 0; i < k; i++) {
            star[i][0] = sc.nextInt();
            star[i][1] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int x = star[i][0];
                int y = star[j][1];
                cnt = 0;
                for (int[] dot : star) {
                    if (x <= dot[0] && x + l >= dot[0] && y <= dot[1] && y + l >= dot[1])
                        cnt++;
                }
                answer = Math.max(answer, cnt);

            }
        }
        System.out.println(k - answer);
    }
}