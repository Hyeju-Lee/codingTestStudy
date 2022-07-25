import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int num;
    int time;
    Node(int num, int time) {
        this.num = num;
        this.time = time;
    }
}
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] indegree;
    static int[] time;
    static int n;
    static int[] cost;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            n = sc.nextInt();
            int k = sc.nextInt();
            cost = new int[n+1];
            indegree = new int[n+1];
            time = new int[n+1];
            graph = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                cost[i] = sc.nextInt();
            }
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                indegree[b] += 1;
            }
            int w = sc.nextInt();
            topology(w);
        }
    }

    static void topology(int w) {
        Queue<Node> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            time[i] = cost[i];
            if (indegree[i] == 0)
                que.offer(new Node(i, cost[i]));
        }
        while (!que.isEmpty()) {
            Node now = que.poll();
            if (now.num == w)
                System.out.println(now.time);
            for (int i = 0; i < graph.get(now.num).size(); i++) {
                int idx = graph.get(now.num).get(i);
                indegree[idx]--;
                time[idx] = Math.max(time[idx], time[now.num] + cost[idx]);
                if (indegree[idx] == 0)
                    que.offer(new Node(idx, time[idx]));
            }
        }


    }
}