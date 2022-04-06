import java.util.*;
class Queue_2 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int max = queue.poll();
            boolean flag = false;
            for (Integer i : queue) {
                if(priorities[i] > priorities[max]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                queue.offer(max);
            } else {
                result.add(max);
            }
        }

        for(int i = 0; i < result.size(); i++) {
            if (result.get(i) == location)
                answer = i+1;
        }

        return answer;
    }
}
