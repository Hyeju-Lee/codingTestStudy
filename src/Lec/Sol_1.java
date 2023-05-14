// don't place package name.

import java.io.*;
import java.util.*;

// don't change 'Program' class name and without 'public' accessor.
class Program {
    static boolean[][] visited;
    static int[][] loc;
    static int[][] map;
    static ArrayList<int[]> emp = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        map = new int[n][m];
        loc = new int[3][2];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j)-'0';
                if(map[i][j] == 1) emp.add(new int[]{i,j});
            }
        }
        dfs(0,n,m,0);
        System.out.println(answer);
    }

    static void dfs(int depth, int n, int m, int idx) {
        if (depth >= 3) {
            calc();
            return;
        }
        for (int i = idx; i < n*m; i++) {
            int x = i/m;
            int y = i%m;

            loc[depth][0] = x;
            loc[depth][1] = y;
            dfs(depth+1, n, m, i);

        }
    }

    static void calc() {
        int sum = 0;
        for(int i = 0; i < emp.size(); i++) {
            int ex = emp.get(i)[0];
            int ey = emp.get(i)[1];
            for (int j = 0; j < 3; j++) {
                int lx = loc[j][0];
                int ly = loc[j][1];
                sum += Math.abs(ex-lx) + Math.abs(ey-ly);
            }
        }
        answer = Math.min(answer, sum);
    }
}