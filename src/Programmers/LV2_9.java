import java.util.*;

public class LV2_9 {
    class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Queue<Integer> truck = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < order.length; i++) {
                truck.offer(i+1);
            }
            int i=0;
            while(!truck.isEmpty()) {
                if (i == order.length) break;
                if (truck.peek() == order[i]) {
                    truck.poll();
                    i++;
                    continue;
                }
                if (!stack.isEmpty() && stack.peek() == order[i]) {
                    stack.pop();
                    i++;
                    continue;
                }
                while(!truck.isEmpty()) {
                    int now = truck.poll();
                    if (now == order[i]) {
                        i++;
                        break;
                    }
                    stack.push(now);
                }
            }

            while(!stack.isEmpty() && i < order.length) {
                if(stack.pop() == order[i]) {
                    i++;
                }
                else
                    break;
            }
            answer = i;
            return answer;
        }
    }
}
