import java.util.*;
class JadenCase {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            String tmp = str[i];
            if (tmp.length() == 0) {
                answer += " ";
            }
            else {
                answer += tmp.substring(0,1).toUpperCase();
                answer += tmp.substring(1,tmp.length()).toLowerCase();
                answer += " ";
            }
        }
        if (s.substring(s.length()-1, s.length()).equals(" ")) return answer;
        return answer.substring(0,answer.length()-1);
    }
}