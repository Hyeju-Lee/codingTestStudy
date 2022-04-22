import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] a;
    static int[] operator;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        operator = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, a[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int num) {
        if (depth == n) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0 :
                        dfs(depth+1, num + a[depth]);
                        break;
                    case 1:
                        dfs(depth+1, num - a[depth]);
                        break;
                    case 2:
                        dfs(depth+1, num * a[depth]);
                        break;
                    case 3:
                        dfs(depth+1, num / a[depth]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}