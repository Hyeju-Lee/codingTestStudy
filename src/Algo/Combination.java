
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int r = 2;
        combination(arr, r, 0, new boolean[arr.length], new int[r], 0);
    }
    static void combination(int[] arr, int r, int depth, boolean[] visited, int[] result, int idx) {
        if (depth == r) {
            for (int n : result) System.out.print(n + " ");
            System.out.println();
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                combination(arr, r, depth + 1, visited, result, i);
                visited[i] = false;
            }

        }
    }
}