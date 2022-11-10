import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] graph;
    static int[] parent;
    static int cnt = 0;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new int[m][3];
        parent = new int[n+1];
        for (int i = 0; i < m; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
        }
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            if (cnt == n-1) break;
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                answer += graph[i][2];
                cnt++;
            }
        }
        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x > y) parent[x] = y;
            else parent[y] = x;
        }
    }

}
