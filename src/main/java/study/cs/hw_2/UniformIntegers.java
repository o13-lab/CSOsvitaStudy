package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UniformIntegers {

    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);

            String output = solve(a, b) + "";

            System.out.println(output);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static int solve(long a, long b) {
        int counter = 0;


        for (int digit = 1; digit <= 9; digit++) {
            long num = digit;

            while (num <= b) {
                if (num >= a) {
                    counter++;
                }

                num = num * 10 + digit;
            }
        }

        return counter;
    }


    public int count(long a, long b) {
        return solve(a, b);
    }

}
