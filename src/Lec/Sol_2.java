import java.util.Scanner;

class Program {
    static int count = 0;
    static boolean[] visited;
    public static void combinationSum(int depth, int target, int idx, int sum, int n, int k) {
        if (depth == k) { // 합이 n과 같으면 경우의 수 1 증가
            if (sum == target) count++;
            return;
        }

        for (int i = idx; i <= n; i++) {
            if (!visited[i]) {
                int newSum = sum + i;
                if (newSum <= target) {
                    visited[i] = true;
                    combinationSum(depth+1, target, i + 1, newSum, n, k);
                    visited[i] = false;
                }

                else return;

            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 합이 n이 되어야 함
        int k = scanner.nextInt();  // 숫자 k개를 더해서 합이 n이 되어야 함
        visited = new boolean[n+1];

        combinationSum(0, n, 1, 0,n,k);
        System.out.println(count);
    }
}
