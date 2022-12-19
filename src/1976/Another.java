import java.util.Scanner;

public class Another {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //연결정보저장
        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    union(i, j);
                }
            }
        }

        int start = sc.nextInt();
        for (int i = 1; i < m; i++) {
            int next = sc.nextInt();
            if (parent[start] != parent[next]) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) parent[x] = y;
        else parent[y] = x;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
