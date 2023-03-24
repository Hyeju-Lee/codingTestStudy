import java.util.*;
class LV2_8 {
    static ArrayList<Character> op;
    static ArrayList<String> ex;
    static long answer;
    public long solution(String expression) {
        answer = 0;
        StringTokenizer st = new StringTokenizer(expression, "\\*|\\+|-", true);
        op = new ArrayList<>();
        ex = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String now = st.nextToken();
            if (now.equals("+") || now.equals("*") || now.equals("-")) {
                if (!op.contains(now.charAt(0)))
                    op.add(now.charAt(0));
            }
            ex.add(now);
        }

        boolean[] visited = new boolean[op.size()];
        permutation(visited, 0, op.size(), new int[op.size()]);
        return answer;
    }

    public void permutation(boolean[] visited, int depth, int r, int[] result) {
        if (depth == r) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < result.length; i++) {
                map.put(op.get(result[i]), i);
                System.out.print(result[i]+" "+op.get(result[i])+" ");
            }
            calc(result, map);
            System.out.println(answer);
            return;
        }
        for (int i = 0; i < r; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(visited, depth+1, r, result);
                visited[i] = false;
            }
        }
    }

    public void calc(int[] result, HashMap<Character, Integer> map) {
        Stack<Long> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        for (int i = 0; i < ex.size(); i++) {
            String tmp = ex.get(i);
            if (tmp.equals("+") || tmp.equals("-") || tmp.equals("*")) {
                if (opStack.isEmpty()) {
                    opStack.push(tmp.charAt(0));
                    continue;
                }
                if (map.get(opStack.peek()) > map.get(tmp.charAt(0))) {
                    opStack.push(tmp.charAt(0));
                    continue;
                }
                while(true) {
                    if (opStack.isEmpty() || map.get(opStack.peek()) > map.get(tmp.charAt(0))) break;
                    if (map.get(opStack.peek()) <= map.get(tmp.charAt(0))) {
                        Character now = opStack.pop();
                        long b = numStack.pop();
                        long a = numStack.pop();
                        long res = 0;
                        switch(now) {
                            case '+':
                                res = a + b;
                                break;
                            case '-':
                                res = a-b;
                                break;
                            case '*':
                                res = a*b;
                                break;
                        }
                        numStack.push(res);
                    }

                }
                opStack.push(tmp.charAt(0));
            }
            else {
                numStack.push(Long.parseLong(tmp));
            }
        }

        while(!opStack.isEmpty()) {
            long y = numStack.pop();
            long x = numStack.pop();
            char o = opStack.pop();
            long tmp = 0;
            switch(o) {
                case '+':
                    tmp = x + y;
                    break;
                case '-':
                    tmp = x-y;
                    break;
                case '*':
                    tmp = x*y;
                    break;
            }
            numStack.push(tmp);
        }
        answer = Math.max(answer, Math.abs(numStack.pop()));

    }
}
