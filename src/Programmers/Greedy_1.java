import java.util.*;
class Greedy_1 {
    public int solution(String name) {
        int answer = 0;
        int leng = name.length();
        int move = leng - 1;
        for (int i = 0; i < leng; i++) {
            //상하 이동
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            //좌우 이동
            int next = i+1;
            while(next < leng && name.charAt(next) == 'A')
                next++;
            move = Math.min(move, i*2 + leng - next);
            move = Math.min(move, (leng - next)*2 + i);
        }
        answer += move;
        return answer;
    }
}
