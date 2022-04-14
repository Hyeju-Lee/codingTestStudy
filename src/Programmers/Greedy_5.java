import java.util.Arrays;

public class Greedy_5 {
    int[] parent;

    public int Solution(int n, int[][] costs) {
        int answer = 0;
        int line = 0;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        for (int i = 0; i < costs.length; i++) {
            if (line == n - 1) break;
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
                line++;
            }

        }
        return answer;
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
