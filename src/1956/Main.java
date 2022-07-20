import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        long[][] graph = new long[V+1][V+1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < E; i++) {
            graph[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        long min = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++) {
            min = Math.min(graph[i][i], min);
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}