import java.util.*;

class Node implements Comparable<Node>{
    private int end;
    private int cost;
    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    public int getEnd() {
        return end;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Node node) {
        if (this.getCost() < node.cost)
            return -1;
        return 1;
    }
}
public class Main {
    static int n;
    static int[] table;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        table = new int[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(start).add(new Node(end, cost));
        }
        int sn = sc.nextInt();
        int en = sc.nextInt();
        Arrays.fill(table, (int)1e9);
        dijkstra(sn);
        System.out.println(table[en]);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start, 0));
        table[start] = 0;
        while (!que.isEmpty()) {
            Node now = que.poll();
            int end = now.getEnd();
            if (table[end] < now.getCost()) continue;
            for (int i = 0; i < graph.get(end).size(); i++) {
                int value = table[end] + graph.get(end).get(i).getCost();
                if (value < table[graph.get(end).get(i).getEnd()]) {
                    table[graph.get(end).get(i).getEnd()] = value;
                    que.offer(new Node(graph.get(end).get(i).getEnd(), value));
                }
            }
        }
    }
}
