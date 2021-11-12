import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            if (k <= 0) negative.add(k);
            else positive.add(k);
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        for (int i = 0; i < positive.size(); i+=2) {
            if ((i+1) < positive.size()) {
                if (positive.get(i) == 1 || positive.get(i+1) == 1) {
                    answer += positive.get(i);
                    answer += positive.get(i+1);
                    continue;
                }
                else
                    answer += positive.get(i) * positive.get(i+1);
            }

            else {
                if (positive.get(i) == 1) {
                    answer += positive.get(i);
                    continue;
                }
                else
                    answer += positive.get(i);
            }
        }

        for (int i = 0; i < negative.size(); i+=2) {
            if (i+1 < negative.size())
                answer += negative.get(i) * negative.get(i+1);
            else
                answer += negative.get(i);
        }

        System.out.println(answer);

    }
}