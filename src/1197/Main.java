
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int answer;
    static int[] parent;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        graph = new int[E][3];
        for (int i = 0; i < E; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
        }
        parent = new int[V+1];
        answer = 0;

        Arrays.sort(graph, (o1,o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int n = 0;
        for (int i = 0; i < E; i++) {
            if (n >= V-1) break;
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                n++;
                answer += graph[i][2];
            }
        }
        System.out.println(answer);

    }

    static int find(int x) {
        if (x == parent[x]) return x;
        else return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) parent[x] = y;
        else parent[y] = x;
    }
}