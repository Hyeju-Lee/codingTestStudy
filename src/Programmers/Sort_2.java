import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numString = new String[numbers.length];
        for (int i = 0 ; i < numbers.length; i++) {
            numString[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numString, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return ((o2+o1).compareTo(o1+o2));//내림차순
                //오름차순 = (o1+o2).compareTo(o2+o1)
            }
        });

        if(numString[0].equals("0"))
            return "0";

        for (String str : numString) {
            answer += str;
        }
        return answer;
    }
}