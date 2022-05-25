class DFS_1 {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, numbers, target, 0);
        return answer;
    }
    public void dfs(int depth, int[] numbers, int target, int tmp) {
        if (depth == numbers.length) {
            if (tmp == target) {
                answer++;
                return;
            }
            return;
        }
        dfs(depth+1, numbers, target, tmp - numbers[depth]);
        dfs(depth+1, numbers, target, tmp + numbers[depth]);
    }
}
