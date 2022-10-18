
public class KMP {
    static int[] pi;
    public static void main(String[] args) {
        String pattern = "abacaaba";
        String parent = "ababacabacaabacaaba";
        pi = new int[pattern.length()];
        makeTable(pattern);
        kmp(pattern, parent);
    }
    static void makeTable(String pattern) {
        int idx = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (idx > 0 && pattern.charAt(idx) != pattern.charAt(i)) {
                idx = pi[idx-1];
            }
            if (pattern.charAt(idx) == pattern.charAt(i)) {
                idx++;
                pi[i] = idx;
            }
        }
    }

    static void kmp(String pattern, String parent) {
        int j = 0;
        for (int i = 0; i < parent.length(); i++) {
            while (j > 0 && pattern.charAt(j) != parent.charAt(i)) {
                j = pi[j-1];
            }
            if (pattern.charAt(j) == parent.charAt(i)) {
                if (j == pattern.length()-1) {
                    System.out.println(i-pattern.length()+2+"번째에서 찾았습니다");
                    break;
                }
                else
                    j++;
            }
        }
    }
}
