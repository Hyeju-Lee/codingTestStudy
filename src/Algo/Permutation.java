public class Permutation {   //순열
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int r = 2;
        permutation(arr, r, 0, new boolean[arr.length], new int[r]);
    }
    static void permutation(int[] arr, int r, int depth, boolean[] visited, int[] result) {
        if (depth == r) {
            for (int n : result) System.out.print(n + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(arr, r, depth+1, visited, result);
                visited[i] = false;
            }
        }
    }
}