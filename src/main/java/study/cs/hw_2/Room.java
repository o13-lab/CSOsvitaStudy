package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Room {

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


        return counter;
    }

}
