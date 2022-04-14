import java.util.*;
class Greedy_4 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        int max = people.length - 1;
        while (min <= people.length - 1 && max >= 0 && min <= max) {
            if (min == max) {
                answer++;
                break;
            }
            if (people[max] + people[min] <= limit) {
                min++;
                max--;
            }
            else {
                max--;
            }
            answer++;
        }
        return answer;
    }
}
