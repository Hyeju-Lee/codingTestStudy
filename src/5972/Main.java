import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int end;
    int cost;
    Node (int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
        if (this.cost < node.cost)
            return -1;
        return 1;
    }
}
public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int[] table;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        table = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        Arrays.fill(table, (int)1e9);
        dijkstra(1);
        System.out.println(table[n]);
    }
    static void dijkstra(int start) {
        table[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        visited[start] = true;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.end;
            if (table[index] < now.cost) continue;
            for (int i = 0; i < graph.get(index).size(); i++) {
                int value = table[index] + graph.get(index).get(i).cost;
                if (value < table[graph.get(index).get(i).end]) {
                    table[graph.get(index).get(i).end] = value;
                    pq.offer(new Node(graph.get(index).get(i).end, value));
                }
            }
        }
    }
}