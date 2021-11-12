import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] t0, int[] t1) {
                if (t0[1] == t1[1]) {
                    return t0[0] - t1[0];
                }
                return t0[1] - t1[1];
            }
        });

        int count = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            if (endTime <= arr[i][0]) {
                endTime = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}