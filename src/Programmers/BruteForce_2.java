import java.util.*;

public class BruteForce_2 {
    HashSet<Integer> numSet = new HashSet<>();

    public boolean isPrime(int n) {
        if (n == 1 || n == 0)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) { //에라토스테네스의 체 사용
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public void recursive(String comb, String others) {   //가능한 모든 숫자 조합을 numSet에 추가
        if (!comb.equals(""))
            numSet.add(Integer.valueOf(comb));
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i),
                    others.substring(0,i) + others.substring(i+1));
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        recursive("", numbers);

        Iterator<Integer> it = numSet.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (isPrime(num))
                answer++;
        }


        return answer;
    }
}
