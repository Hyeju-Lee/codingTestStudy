import java.util.*;
class Main {
    static int l,c;
    static char[] ch;
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        ch = new char[c];
        visited = new boolean[c];
        for (int i = 0; i < c; i++) {
            ch[i] = sc.next().charAt(0);
        }
        Arrays.sort(ch);
        dfs(0, "", 0);
    }

    static void dfs(int depth, String result, int idx) {
        if (depth == l) {
            if (check(result)) {
                System.out.println(result);
            }
            return;
        }

        for (int i = idx; i < ch.length; i++) {
            result += Character.toString(ch[i]);
            dfs(depth+1, result, i+1);
            result = result.substring(0,result.length()-1);
        }
    }

    static boolean check(String result) {
        int m=0;
        int j=0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == 'a' || result.charAt(i) == 'e' || result.charAt(i) == 'i' ||
                    result.charAt(i) == 'o' || result.charAt(i) == 'u') {
                m++;
            }
            else j++;
        }
        if (m > 0 && j >1) return true;
        return false;
    }
}
