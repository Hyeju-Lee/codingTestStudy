
import javax.management.InstanceNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node node) {
            if (this.cost < node.cost)
                return -1;
            return 1;
        }
    }
    static int n,m;
    static ArrayList<Node>[] list;
    static int[] di;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        di = new int[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Arrays.fill(di, 1000);
        System.out.print(dijkstra(s, t));
    }

    static int dijkstra(int start, int end) {
        di[start] = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start, 0));
        while (!que.isEmpty()) {
            Node now = que.poll();
            if (di[now.idx] < now.cost) continue;
            for (int i = 0; i < list[now.idx].size(); i++) {
                int idx = list[now.idx].get(i).idx;
                int cost = list[now.idx].get(i).cost;
                if (di[now.idx] + cost < di[idx]) {
                    di[idx] = di[now.idx] + cost;
                    que.offer(new Node(idx, di[idx]));
                }
            }
        }
        return di[end];
    }
}