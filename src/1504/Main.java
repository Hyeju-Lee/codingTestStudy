import java.util.*;

class Node implements Comparable<Node> {
    int dest;
    int cost;
    Node(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
    public int compareTo(Node node) {
        if (node.cost > this.cost)
            return -1;
        return 1;
    }
}
public class Main {
    static int n,e;
    static ArrayList<ArrayList<Node>> graph;
    static final int INF = 200000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int res1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
        int res2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

        int result = (res1 >= INF && res2 >= INF) ? -1
                : Math.min(res1, res2);

        System.out.print(result);
    }

    static int dijkstra(int start, int end) {
        int[] table = new int[n+1];
        Arrays.fill(table, INF);
        table[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > table[now.dest]) continue;
            for (int i = 0; i < graph.get(now.dest).size(); i++) {
                Node node = graph.get(now.dest).get(i);
                if (table[now.dest] + node.cost < table[node.dest]) {
                    table[node.dest] = table[now.dest] + node.cost;
                    pq.offer(new Node(node.dest, table[node.dest]));
                }
            }
        }

        return table[end];
    }
}