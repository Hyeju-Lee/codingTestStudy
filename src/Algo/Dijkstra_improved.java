import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node node) {
        if (this.distance < node.distance)
            return -1;
        return 1;
    }
}
public class Dijkstra_improved {

    static final int INF = (int) 1e9;
    static int n,m,start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] table = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        table[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();
            if (table[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = table[now] + graph.get(now).get(i).getDistance();
                if (cost < table[graph.get(now).get(i).getIndex()]) {
                    table[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        //테이블을 모두 무한으로 초기화
        Arrays.fill(table, INF);
        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (table[i] == INF)
                System.out.println("infinite");
            else
                System.out.println(table[i]);
        }
    }
}
