import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int n,m;
    static List<int[]> house;
    static List<int[]> chicken;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static List<Integer> selected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][n+1];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        selected = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1)
                    house.add(new int[]{i,j});
                else if (map[i][j] == 2)
                    chicken.add(new int[]{i,j});
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int index) {
        if (depth >= m) {
            countDist();
            return;
        }
        for (int i = index; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(i);
                dfs(depth+1, i+1);
                visited[i] = false;
                selected.remove(selected.size()-1);
            }
        }
    }

    static void countDist() {
        int tmp = 0;
        for (int i = 0; i < house.size(); i++) {
            int[] nowHouse = house.get(i);
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < selected.size(); j++) {
                int[] nowChicken = chicken.get(selected.get(j));
                int dist = Math.abs(nowChicken[0] - nowHouse[0]) + Math.abs(nowChicken[1] - nowHouse[1]);
                minDist = Math.min(dist, minDist);
            }
            tmp += minDist;
        }
        answer = Math.min(answer, tmp);
    }
}