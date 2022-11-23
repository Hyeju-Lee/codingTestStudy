import java.util.*;

class Node implements Comparable<Node>{
    int dest;
    int cost;
    Node (int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public int compareTo(Node o1) {
        if (this.cost < o1.cost)
            return -1;
        return 1;
    }
}
public class Main {
    static int n, q;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < n-1; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            graph.get(p).add(new Node(q,r));
            graph.get(q).add(new Node(p,r));
        }
        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            System.out.println(bfs(v, k));
        }
    }

    public static int bfs(int start, int k) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int cnt = 0;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int dest = graph.get(now).get(i).dest;
                int cost = graph.get(now).get(i).cost;
                if (visited[dest] || cost < k) {
                    continue;
                }
                visited[dest] = true;
                cnt++;
                que.offer(dest);
            }
        }
        return cnt;
    }
}