class LV2_5 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int cnt = 0;
        while (true) {
            if (s.equals("1")) break;
            int one = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') one++;
            }
            zero += (s.length() - one);
            s = Integer.toString(one, 2);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }
}
