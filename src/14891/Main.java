import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static Deque<String>[] dq;
    static boolean visited[] = new boolean[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dq = new ArrayDeque[4];
        for (int i = 0; i < 4; i++) {
            dq[i] = new ArrayDeque<>();
            String str = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                dq[i].add(String.valueOf(str.charAt(j)));
            }
        }


        int k = sc.nextInt();
        while (k--> 0) {
            int num = sc.nextInt()-1;
            int dir = sc.nextInt();
            visited[num] = true;
            rotate(num, dir);
            visited[num] = false;
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (dq[i].peekFirst().equals("1"))
                answer += Math.pow(2,i);
        }

        System.out.println(answer);
    }

    static void rotate(int num, int dir) {
        if (num < 0 || num > 3) return;
        String[] arr = new String[dq[num].size()];
        dq[num].toArray(arr);
        if (num - 1 >= 0 && !visited[num-1]) {
            String[] left = new String[dq[num-1].size()];
            dq[num-1].toArray(left);
            if (!arr[6].equals(left[2])) {
                visited[num-1] = true;
                rotate(num-1, dir * (-1));
                visited[num-1] = false;
            }
        }

        if (num + 1 < 4 && !visited[num+1]) {
            String[] right = new String[dq[num+1].size()];
            dq[num+1].toArray(right);
            if (!arr[2].equals(right[6])) {
                visited[num+1] = true;
                rotate(num+1, dir * (-1));
                visited[num+1] = false;
            }
        }

        if (dir == -1) {
            dq[num].addLast(dq[num].removeFirst());
        }
        else if (dir == 1)
            dq[num].addFirst(dq[num].removeLast());

    }

}