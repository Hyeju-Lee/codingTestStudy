import java.util.*;
class Sort_1 {
    int[] answer;
    int count = 0;
    public int[] solution(int[] array, int[][] commands) {
        answer = new int[commands.length];
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            sort(array,i,j,k);
        }
        return answer;
    }

    public void sort(int[] array, int i, int j, int k) {
        List<Integer> temp = new ArrayList<>();
        for (int m = i-1; m < j; m++) {
            temp.add(array[m]);
        }
        Collections.sort(temp);
        answer[count++] = temp.get(k-1);
    }
}