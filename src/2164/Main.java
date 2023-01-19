
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        recursion(list);
    }
    static void recursion(ArrayList<Integer> list) {
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }
        ArrayList<Integer> next = new ArrayList<>();
        if (list.size() % 2 != 0) {
            next.add(list.get(list.size()-1));
        }
        for (int i = 1; i < list.size(); i+=2) {
            next.add(list.get(i));
        }
        recursion(next);
    }
}