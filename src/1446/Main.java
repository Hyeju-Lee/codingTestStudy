import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
    private int endPoint;
    private int value;
    Node(int endPoint, int value) {
        this.endPoint = endPoint;
        this.value = value;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public int getValue() {
        return value;
    }
}
public class Main {
    static int[] table;
    static int d;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = sc.nextInt();
        graph = new ArrayList<>();
        table = new int[d+1];
        for (int i = 0; i <= d; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();
            if (end - start <= dist) continue;
            if (end > d) continue;
            graph.get(start).add(new Node(end, dist));
        }
        Arrays.fill(table, (int)1e9);
        table[0] = 0;
        dijkstra(0);
        System.out.println(table[d]);
    }
    static void dijkstra(int start) {
        if (start >= d) return;
        if (table[start+1] > table[start] + 1)
            table[start+1] = table[start] + 1;
        for (int i = 0; i < graph.get(start).size(); i++) {
            int cost = table[start] + graph.get(start).get(i).getValue();
            if (cost < table[graph.get(start).get(i).getEndPoint()])
                table[graph.get(start).get(i).getEndPoint()] = cost;
        }
        dijkstra(start+1);
    }
}
