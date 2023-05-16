// don't place package name.

import java.io.*;
import java.util.*;

// don't change 'Program' class name and without 'public' accessor.
class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt()-1;
        int b = scanner.nextInt()-1;
        if (a == 0) {
            System.out.println(fibo(b));
            System.exit(0);
        }
        System.out.println(fibo(b) - fibo(a-1));
    }
    static int fibo(int a) {
        int idx = 0;
        int sum = 0;
        int num = 0;
        int f = 0;
        int s = 0;
        while(idx <= a) {
            if (idx == 0 || idx == 1) {
                num = 1;
                f = 1;
                sum += num;
                idx++;
            }
            else if (idx == 2 || idx == 3) {
                num = 2;
                s = 2;
                idx++;
                sum += num;
            }
            else {
                num = f+s;
                int cnt = 0;
                while (idx <= a && cnt < num) {
                    sum += num;
                    idx++;
                    cnt++;
                }
                f = s;
                s = num;
            }
        }
        return sum;
    }
}