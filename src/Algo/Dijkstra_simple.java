import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
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
        return distance;
    }
}
public class Dijkstra_simple {
    static final int INF = (int)1e9;  //무한 의미하는 10억
    static int n,m,start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static boolean[] visited = new boolean[100001];
    static int[] table = new int[100001];

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int min = INF;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (table[i] < min && !visited[i]) {
                min = table[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int start) {
        table[start] = 0;
        visited[start] = true;
        for (int i = 0; i < graph.get(start).size(); i++) {
            table[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }
        for (int i = 0; i < n-1; i++) {
            int now = getSmallestNode();
            visited[now] = true;
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = table[now] + graph.get(now).get(j).getDistance();
                if (cost < table[graph.get(now).get(j).getIndex()])
                    table[graph.get(now).get(j).getIndex()] = cost;
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        //그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(table, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (table[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(table[i]);
            }
        }
    }
}