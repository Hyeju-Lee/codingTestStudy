import java.util.*;

class Stack_1 {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        int n = progresses.length;
        List<Integer> cnt = new ArrayList<Integer>();
        for(int i = n-1; i >= 0; i--) {
            stack.push(((100-progresses[i])/speeds[i])
                    + ((100-progresses[i]) % speeds[i] > 0 ? 1 : 0));
        }

        while(!stack.isEmpty()) {
            int count = 1;
            int top = stack.pop();
            while (!stack.isEmpty() && stack.peek() <= top) {
                count++;
                stack.pop();
            }
            cnt.add(count);
        }

        int[] answer = new int[cnt.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = cnt.get(i);
        }


        return answer;
    }
}


