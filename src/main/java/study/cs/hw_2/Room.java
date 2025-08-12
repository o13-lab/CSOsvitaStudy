package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Room {

    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int nab = Integer.parseInt(input[1]);
            int nbc = Integer.parseInt(input[2]);
            int nac = Integer.parseInt(input[3]);

            String output = solve(n, nab, nbc, nac);

            System.out.println(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static String solve(int n, int nab, int nbc, int nac) {
        int c = nab + nbc + nac - n;

        if (c < 0) {
            return "NO";
        }

        var output = new StringBuilder();
        for (int c1 = 0; c1 <= c; c1++) {
            for (int c2 = 0; c2 <= c - c1; c2++) {
                int c3 = c - c1 - c2;

                int sAB = nab - c1 - c2;
                int sBC = nbc - c2 - c3;
                int sAC = nac - c3 - c1;

                if (sAB >= 0 && sBC >= 0 && sAC >= 0) {
                    output.append("YES\n");
                    output.append(c1).append(" ");
                    output.append(sAB).append(" ");
                    output.append(c2).append(" ");
                    output.append(sBC).append(" ");
                    output.append(c3).append(" ");
                    output.append(sAC);
                    return output.toString();
                }
            }
        }

        return "NO";
    }

    public String calc(int n, int nab, int nbc, int nac) {
        return solve(n, nab, nbc, nac);
    }

}
