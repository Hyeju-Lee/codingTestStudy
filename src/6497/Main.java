
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int m,n;
    static int[][] graph;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;
            graph = new int[n][3];
            parent = new int[m+1];
            int total = 0;
            for (int i = 1; i <= m; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                graph[i][2] = Integer.parseInt(st.nextToken());
                total += graph[i][2];
            }
            Arrays.sort(graph, (o1,o2) -> Integer.compare(o1[2], o2[2]));
            int v = 0;
            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (find(graph[i][0]) != find(graph[i][1])) {
                    v++;
                    union(graph[i][0], graph[i][1]);
                    answer += graph[i][2];
                }
                if (v == m-1) break;
            }

            System.out.print(total - answer);
        }

    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) parent[x] = y;
        else parent[y] = x;
    }
}