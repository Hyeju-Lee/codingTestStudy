import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        while (st.hasMoreTokens()) {
            int tmp = 0;
            StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");
            while (addition.hasMoreTokens()) {
                tmp += Integer.parseInt(addition.nextToken());
            }
            if (answer == Integer.MAX_VALUE)
                answer = tmp;
            else
                answer -= tmp;

        }
        System.out.println(answer);

    }
}