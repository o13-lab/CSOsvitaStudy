package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Division {

  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      int input = Integer.parseInt(reader.readLine());

      long t = System.currentTimeMillis();
      List<String> results = solve(input);
      System.out.println("took: " + (System.currentTimeMillis() - t) + " ms");

      if (results.isEmpty()) {
        System.out.println("There are no solutions for %d.".formatted(input));
      } else {
        for (int i = results.size() - 1; i >= 0 ; i--) {
          System.out.println(results.get(i));
        }
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  private static List<String> solve(int input) {
    List<String> results = new ArrayList<>();

    int a = 98765;
    int b = 1234;

    while (a >= b * input) {
      if (a % input != 0) {
        a--;
        continue;
      }
      if (!allDigitsDiff(a)) {
        a--;
        continue;
      }

      int tempB = b;
      while (a >= tempB * input) {
        if (a % tempB == 0) {
          int rez = a / tempB;
          if (input == rez && allDigitsDiff(a, tempB)) {
            String output = "%d / %05d = %d".formatted(a, tempB, rez);
            results.add(output);
          }
        }
        tempB++;
      }
      a--;
    }

    return results;

  }

  private static boolean allDigitsDiff(int a, int b) {
    Set<Integer> nums = new HashSet<>();

    for (int i = 4; i >= 0; i--) {
      int num = a % 10;
      if (!nums.add(num)) {
        return false;
      }
      a /= 10;
    }

    for (int i = 9; i >= 5; i--) {
      int num = b % 10;
      if (!nums.add(num)) {
        return false;
      }
      b /= 10;
    }
    return true;
  }

  private static boolean allDigitsDiff(int a) {
    Set<Integer> nums = new HashSet<>();
    for (int i = 4; i >= 0; i--) {
      int num = a % 10;
      if (!nums.add(num)) {
        return false;
      }
      a /= 10;
    }
    return true;
  }

}
