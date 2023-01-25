import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int idx;
    int cost;
    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    public int compareTo(Node node) {
        if (this.cost < node.cost)
            return -1;
        return 1;
    }
}
public class Main {
    static int v,e,p;
    static ArrayList<Node>[] road;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        road = new ArrayList[v+1];
        for (int i = 0; i <= v; i++) {
            road[i] = new ArrayList<>();
        }
        while (e--> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            road[a].add(new Node(b,c));
            road[b].add(new Node(a,c));
        }
        if (dijkstra(1,v) >= (dijkstra(1,p) + dijkstra(p,v)))
            System.out.println("SAVE HIM");
        else
            System.out.println("GOOD BYE");
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        int[] table = new int[v+1];
        Arrays.fill(table, 10001);
        table[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > table[now.idx]) continue;
            for (int i = 0; i < road[now.idx].size(); i++) {
                int cost = table[now.idx] + road[now.idx].get(i).cost;
                if (cost < table[road[now.idx].get(i).idx]) {
                    table[road[now.idx].get(i).idx] = cost;
                    pq.add(new Node(road[now.idx].get(i).idx, cost));
                }
            }
        }
        return table[end];
    }
}