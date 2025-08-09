package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Optimisation {

  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      int input = Integer.parseInt(reader.readLine());

      String output = solveInSquareComplexity(input) + "";

      System.out.println(output);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  private static long solve(int n) {
    long cnt = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        for (int k = 1; k <= j; k++) {
          cnt += 1;
        }
      }
    }
    return cnt;
  }

  private static long solveInSquareComplexity(int n) {
    long cnt = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        cnt += j;
      }
    }
    return cnt;
  }

  private static long solveInLinearComplexity(int n) {
    long cnt = 0;
    for (int i = 1; i <= n; i++) {
      cnt += i * (n - i + 1);
    }
    return cnt;
  }

  private static long solveInConstantComplexity(int n) {
    return ((n + 1) * (n * n + 2 * n)) / 6;
  }
}
