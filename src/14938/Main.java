import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int idx;
    int cost;
    Node (int idx, int cost) {
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
    static int n,m,r;
    static int[] item;
    static ArrayList<Node>[] lists;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n+1];
        lists = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        while (r--> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b,l));
            lists[b].add(new Node(a,l));
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }
        System.out.println(max);

    }

    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int[] table = new int[n+1];
        Arrays.fill(table, 10000);
        table[start] = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > table[now.idx]) continue;
            for (int i = 0; i < lists[now.idx].size(); i++) {
                int cost = table[now.idx] + lists[now.idx].get(i).cost;
                if (cost < table[lists[now.idx].get(i).idx]) {
                    table[lists[now.idx].get(i).idx] = cost;
                    pq.add(new Node(lists[now.idx].get(i).idx, cost));
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (table[i] <= m) sum += item[i];
        }
        return sum;
    }
}