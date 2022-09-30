import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Vinit {
    public static void main(String[] args) {
        int n = 456;
        System.out.println(maxStrength(n));
    }

    public static int maxStrength(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(n);
        int i = 0;
        while (true) {
            String num[] = String.valueOf(result.get(i++)).split("");
            int nn = 0;
            for (String s : num) {
                nn += factorial(Integer.parseInt(s));
            }
            if (result.contains(nn)) break;
            result.add(nn);
        }
        return Collections.max(result) * result.size();
    }

    static int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);

    }
}
