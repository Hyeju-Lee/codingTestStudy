import java.util.*;
class Greedy_6 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int min = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (min < route[0]) {   //안 겹치는 경우
                answer++;
                min = route[1];
            }
        }
        return answer;
    }
}