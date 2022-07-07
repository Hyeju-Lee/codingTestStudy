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
    static int x;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        x = sc.nextInt();
        int answer = 0;
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
        for (int i = 1; i <= n; i++) {
            table = new int[n+1];
            Arrays.fill(table, (int)1e9);
            dijkstra(i);
            int time = table[x];
            table = new int[n+1];
            Arrays.fill(table, (int)1e9);
            dijkstra(x);
            time += table[i];
            answer = Math.max(answer, time);
        }
        System.out.println(answer);
    }

    static void dijkstra(int start) {
        table[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (table[now.end] < now.cost) continue;
            int index = now.end;
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