import java.util.*;

public class Main {
    static int[] belt;
    static boolean[] robot;
    static int n, k;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        belt = new int[2*n];
        robot = new boolean[n];
        for (int i = 0; i < 2*n; i++) {
            belt[i] = sc.nextInt();
        }
        answer = 0;
        while (true) {
            answer++;
            rotation();
        }

    }
    static void rotation() {
        int tmp = belt[2*n -1];
        for (int i = belt.length-1; i > 0; i--) {
            belt[i] = belt[i-1];
        }
        belt[0] = tmp;

        for (int i = robot.length-1; i > 0; i--) {
            robot[i] = robot[i-1];
        }
        robot[0] = false;

        //내리는 위치에 로봇 있으면 내림
        if (robot[n-1]) robot[n-1] = false;

        for (int i = robot.length-2; i >= 0; i--) {
            if (robot[i]) {
                if (!robot[i+1] && belt[i+1] >= 1) {
                    robot[i+1] = true;
                    belt[i+1]--;
                    robot[i] = false;
                }
            }
        }

        if (robot[n-1]) robot[n-1] = false;

        if (belt[0] > 0) {
            robot[0] = true;
            belt[0]--;
        }

        int cnt = 0;
        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0)
                cnt++;
            if (cnt >= k) {
                System.out.println(answer);
                System.exit(0);
            }
        }

    }

}