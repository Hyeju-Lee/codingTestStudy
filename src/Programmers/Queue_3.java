import java.util.*;
class Queue_3 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> que = new LinkedList<>();
        int time = 0;
        int allWeight = 0;
        for (int i = 0; i < truck_weights.length; i++) { //모든 트럭을 다리에 올리는 반복 
            int truck = truck_weights[i];
            while(true) {
                if(que.isEmpty()) { //큐가 비어있다면 새로운 트럭 넣어줌
                    que.offer(truck);
                    allWeight += truck;
                    time++;
                    break;
                }
                else if(que.size() == bridge_length) { //꽉 찼다면 다 건넌 트럭 꺼내줌
                    allWeight -= que.poll();
                }
                else { //큐에 빈 자리 있는 경우
                    if(allWeight + truck <= weight) {
                        que.offer(truck);
                        allWeight += truck;
                        time++;
                        break;
                    } else { //무게 때문에 못 올라가면 0을 넣어 앞의 트럭을 이동시킴
                        que.offer(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length; //마지막 트럭이 지나가는 시간 더해줌
    }

}