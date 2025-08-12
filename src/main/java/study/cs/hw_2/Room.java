package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Room {

    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int nab = Integer.parseInt(input[0]);
            int nbc = Integer.parseInt(input[0]);
            int nac = Integer.parseInt(input[0]);

            String output = solve(n, nab, nbc, nac);

            System.out.println(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static String solve(int n, int nab, int nbc, int nac) {
        int ka = 0;
        int kab = 0;
        int kb = 0;
        int kbc = 0;
        int kc = 0;
        int kac = 0;

        while (n-- > 0) {
            if (nab >= nbc) {
                if (nab >= nac) {
                    nab--;
                    if (nbc >= nac) {
                        nbc--;
                        kb++;
                    } else {
                        nac--;
                        ka++;
                    }
                }
            } else {
                if (nbc >= nac) {
                    nbc--;
                    if (nac >= nab) {
                        nac--;
                        kc++;
                    } else {
                        nab--;
                        kb++;
                    }
                }
            }
        }


        return (kab == nab && nbc == kbc && nac == kac && n == 0) ? "%d %d %d %d %d %d".formatted(ka, kac, kb, kbc, kc, kac) : "";
}

public String calc(int n, int nab, int nbc, int nac) {
    return solve(n, nab, nbc, nac);
}

}
