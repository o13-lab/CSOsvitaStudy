package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Equation {

  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      int[] input = new int[5];
      for (int i = 0; i < 5; i++) {
        input[i] = Integer.parseInt(reader.readLine().trim());
      }

      String output = solve(input[0], input[1], input[2], input[3], input[4]) + "";
      System.out.println(output);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // (ax^3 + bx^2 + cx + d) / (x - e) = 0 on the interval [0, 1000] and output their count
  private static int solve(int a, int b, int c, int d, int e) {
    int count = 0;
    for (int x = 0; x <= 1000; x++) {
      int numerator = a * x * x * x + b * x * x + c * x + d;
      int denominator = x - e;

      if (denominator != 0) {
        double result = (double) numerator / denominator;
        if (result == 0) {
          count++;
        }
      }
    }

    return count;
  }

}
