import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int end;
    int cost;
    Node(int end, int cost) {
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
    static int[] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            graph = new ArrayList<>();
            dist = new int[n+1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < d; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();
                graph.get(b).add(new Node(a, s));
            }
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(c);
            int answer = 0;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    answer++;
                    max = Math.max(max, dist[i]);
                }
            }
            System.out.println(answer + " " + max);
        }
    }
    static void dijkstra(int c) {
        dist[c] = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(c, 0));
        while (!que.isEmpty()) {
            Node now = que.poll();
            if (dist[now.end] < now.cost) continue;
            for (int i = 0; i < graph.get(now.end).size(); i++) {
                int cost = dist[now.end] + graph.get(now.end).get(i).cost;
                if (cost < dist[ graph.get(now.end).get(i).end]) {
                    dist[graph.get(now.end).get(i).end] = cost;
                    que.offer(new Node(graph.get(now.end).get(i).end, cost));
                }
            }
        }
    }
}