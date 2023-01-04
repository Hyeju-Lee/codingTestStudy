import java.util.Scanner;

public class Main {
    static int n,l;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isPassed(i, 0, 0)) answer++;  //한 행씩 검사
            if (isPassed(0, i, 1)) answer++;  //한 열씩 검사
        }
        System.out.println(answer);

    }

    static boolean isPassed(int x, int y, int d) {
        int[] height = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            height[i] = (d == 0) ? map[x][y+i] : map[x+i][y];
        }

        for (int i = 0; i < n-1; i++) {
            if (height[i] == height[i+1]) continue;

            if (Math.abs(height[i] - height[i+1]) > 1) return false;

            if (height[i] > height[i+1]) { //내려가는 경우
                for (int j = i+1; j <= i+l; j++) {
                    if (j >= n || visited[j] || height[j] != height[i+1])
                        return false;
                    visited[j]= true;
                }
            }

            else if (height[i] < height[i+1]) { //올라가는 경우
                for (int j = i; j > i-l; j--) {
                    if (j < 0 || visited[j] || height[j] != height[i])
                        return false;
                }
            }
        }

        return true;

    }
}