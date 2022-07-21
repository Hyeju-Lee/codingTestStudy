import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] indegree;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        indegree = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b]++;
        }
        topologySort();
    }

    static void topologySort() {
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int now = que.poll();
            result.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)]--;
                if (indegree[graph.get(now).get(i)] == 0)
                    que.offer(graph.get(now).get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
