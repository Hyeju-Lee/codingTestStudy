import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int r,c;
    static boolean visited[][];
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visited = new boolean[r][c];
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        visited[0][0] = true;
        dfs(0,0,0, new ArrayList<>());
        System.out.println(answer+1);
    }
    static void dfs(int x, int y, int depth, ArrayList<Character> road) {
        road.add(map[x][y]);
        answer = Math.max(answer, depth);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (!visited[nx][ny] && !road.contains(map[nx][ny])) {
                visited[nx][ny] = true;
                dfs(nx,ny,depth+1,road);
                visited[nx][ny] = false;
                road.remove(road.size()-1);
            }
        }
    }
}
