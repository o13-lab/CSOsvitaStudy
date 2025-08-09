package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BestNumber {

  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      String[] input = reader.readLine().split(" ");
      int l = Integer.parseInt(input[0]);
      int r = Integer.parseInt(input[1]);

      String output = solve(l, r) + "";
      System.out.println(output);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static int solve(int l, int r) {
    int bestNumber = -1;
    int sumSquaresDigits = 0;

    for (int x = l; x <= r; x++) {
      if (isPrime(x)) {
        int currentSum = getSumOfSquaresDigits(x);
        if (currentSum > sumSquaresDigits) {
          sumSquaresDigits = currentSum;
          bestNumber = x;
        } else if (currentSum == sumSquaresDigits && x < bestNumber) {
          bestNumber = x;
        }
      }
    }

    return bestNumber;
  }

  private static boolean isPrime(int x) {
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }

  private static int getSumOfSquaresDigits(int x) {
    int sum = 0;

    while (x > 0) {
      int digit = x % 10;
      sum += digit * digit;
      x /= 10;
    }

    return sum;
  }
}
