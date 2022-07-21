import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {
    static int v,e;
    static int[] indegree = new int[100001];   //진입차수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void topologySort() {
        ArrayList<Integer> result = new ArrayList<>(); //위상정렬 결과 담을 리스트
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0)
                q.offer(i);    //진입 차수가 0인 노드를 큐에 삽입
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                //now 원소와 연결된 노드들의 진입차수에서 1 빼기
                indegree[graph.get(now).get(i)] -= 1;
                //새롭게 진입차수 0 되는 노드 삽입
                if (indegree[graph.get(now).get(i)] == 0)
                    q.offer(graph.get(now).get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b] += 1;
        }

        topologySort();
    }
}
