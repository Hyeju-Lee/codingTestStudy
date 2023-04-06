import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Again {
    static String[] wheel;
    public static void main(String[] args) throws Exception {
        //2-6연결
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel = new String[4];

        for(int i = 0; i < 4; i++) {
            wheel[i] = br.readLine();
        }
        int k = Integer.parseInt(br.readLine());

        String[] copy = new String[4];
        StringTokenizer st;
        while(k-->0) {
            copy = wheel.clone();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int[] rotated = new int[4];
            //dir = 1 : 시계, -1: 반시계 0: 안 돎
            int tmp = num-1;
            rotated[num-1] = dir;
            rotate(tmp, rotated[tmp]);
            while (true) {
                if (tmp <= 0) break;
                if (rotated[tmp] == 0) break;
                if (copy[tmp].charAt(6) != copy[tmp-1].charAt(2)) {
                    rotate(tmp-1, rotated[tmp]*(-1));
                    rotated[tmp-1] = rotated[tmp]*(-1);
                    tmp--;
                }
                else
                    break;
            }
            tmp = num-1;
            while (true) {
                if (tmp >= 3) break;
                if (rotated[tmp] == 0) break;
                if (copy[tmp].charAt(2) != copy[tmp+1].charAt(6)) {
                    rotated[tmp+1] = rotated[tmp]*(-1);
                    rotate(tmp+1, rotated[tmp+1]);
                    tmp++;
                }
                else
                    break;
            }


        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel[i].charAt(0) == '1') {
                answer += Math.pow(2, i);
            }
        }
        System.out.print(answer);
    }

    static void rotate(int i, int dir) {
        if (dir == 0) return;
        String now = wheel[i];
        if (dir == 1) {
            wheel[i] = String.valueOf(now.charAt(7)) + now.substring(0, 7);
        }
        else {
            wheel[i] = now.substring(1,8) + String.valueOf(now.charAt(0));
        }
    }

}
