import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] lists;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        visited = new boolean[n];
        lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp == -1) continue;
            lists[tmp].add(i);
        }
        int rn = sc.nextInt();
        dfs(rn);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            if (visited[i]) continue;
            for (int j = 0; j < lists[i].size(); j++) {
                if (!visited[lists[i].get(j)])
                    cnt++;
            }
            if (cnt == 0) answer++;
        }
        System.out.println(answer);
    }

    static void dfs(int rn) {
        visited[rn] = true;
        for (int i = 0; i < lists[rn].size(); i++) {
            int idx = lists[rn].get(i);
            if (!visited[idx]) {
                dfs(idx);
            }
        }
    }
}