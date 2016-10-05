package google.codejam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 */
public class JamCoins {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int n = in.nextInt();
            int j = in.nextInt();
            System.out.printf("Case #%d:\n", i + 1);

            int c = 0;
            String v = first(n);
            while (c < j) {
                List<String> factors = new ArrayList<>();
                for (int k = 2; k <= 10; k++) {
                    int val = Integer.parseInt(v, k);
                    for (int l = 2; l <= Math.sqrt(val); l++) {
                        if (val % l == 0) {
                            factors.add(String.valueOf(l));
                            break;
                        }
                    }
                }

                if (factors.size() == 9) {
                    System.out.println(v + " " + String.join(" ", factors));
                }
                v = next(v);
            }
        }
    }


    private static String next(String v) {
        int val = Integer.parseInt(v.substring(1, v.length()), 2);
        val++;
        return "1" + Integer.toBinaryString(val) + "1";
    }

    private static String first(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 0; i < n - 2; i++) {
            sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
}
