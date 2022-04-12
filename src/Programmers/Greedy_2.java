import java.util.*;

class Greedy_2 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int max;
        int index = -1;
        while (k <= number.length() - 1) {
            max = 0;
            for (int i = index+1; i <= k; i++) {
                if (number.charAt(i)-'0' > max) {
                    max = number.charAt(i)-'0';
                    index = i;
                }
            }
            answer.append(max);
            k++;
        }
        return answer.toString();
    }
}
