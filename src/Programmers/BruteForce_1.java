import java.util.*;
class BruteForce_1 {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if (first[i % first.length] == answers[i]) score[0]++;
            if (second[i % second.length] == answers[i]) score[1]++;
            if (third[i % third.length] == answers[i]) score[2]++;
        }
        List<Integer> result = new ArrayList<>();
        int max = Math.max(Math.max(score[0], score[1]), score[2]);
        for (int i = 0; i < 3; i++) {
            if (max == score[i]) result.add(i+1);
        }
        answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);
        return answer;
    }
}
