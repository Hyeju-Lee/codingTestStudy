import java.util.*;


public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] table;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Node(v, w));
        }
        table = new int[V+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if (table[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(table[i]);
        }
    }

    static void dijkstra(int start) {
        table[start] = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start, 0));
        while (!que.isEmpty()) {
            Node node = que.poll();
            int now = node.end;
            if (table[now] < node.cost) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = table[now] + graph.get(now).get(i).cost;
                if (cost < table[graph.get(now).get(i).end]) {
                    table[graph.get(now).get(i).end] = cost;
                    que.offer(new Node(graph.get(now).get(i).end, cost));
                }
            }
        }
    }

}

class Node implements Comparable<Node>{
    int end;
    int cost;
    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
        if (this.cost < node.cost) return -1;
        return 1;
    }
}
