package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Deletion {

  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      String input = reader.readLine();

      String output = solve(input) + "";

      System.out.println(output);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }

  private static int solve(String input) {
    var nums = new int[0];
    char[] number = new char[3];

    for (int i = 0; i < input.length(); i++) {
      char num = input.charAt(i);
      if (num == '0') {
        continue;
      }

      number[0] = num;
      for (int j = i + 1; j < input.length(); j++) {
        number[1] = input.charAt(j);

        for (int k = j + 1; k < input.length(); k++) {
          number[2] = input.charAt(k);

          int candidate = Integer.parseInt(new String(number));
          if (contains(nums, candidate)) {
            continue;
          }
          nums = Arrays.copyOf(nums, nums.length + 1);
          nums[nums.length - 1] = candidate;
        }
      }
    }

    return nums.length;
  }

  private static boolean contains(int[] nums, int num) {
    for (int n : nums) {
      if (n == num) {
        return true;
      }
    }
    return false;
  }
}
