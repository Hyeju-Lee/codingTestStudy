public class LV2_10 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            int left = 0;
            int right = 0;
            int sum = 0;
            int len = 1000001;
            int flag = 0;
            while (true) {
                if (sum >= k) {
                    sum -= sequence[left++];
                    flag = 0;
                }
                else if (right >= sequence.length) break;
                else if (sum < k) {
                    sum += sequence[right++];
                    flag = 1;
                }

                if (sum == k) {
                    if (right - left < len) {
                        answer[0] = left;
                        answer[1] = right-1;
                        len = right-left;
                    }
                }
            }

            return answer;
        }
    }
}
