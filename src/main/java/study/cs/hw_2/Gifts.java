package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gifts {

  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      int[] input = Arrays.stream(reader.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();

      String output = solve(input[0], input[1], input[2], input[3]) + "";
      System.out.println(output);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }

  private static int solve(int x, int y, int z, int weight) {
    int count = 0;

    int sumX = 0;
    for (int i = 0; sumX <= weight; i++) {
      sumX = i * x;
      int sumYX = sumX;
      for (int j = 0; sumYX <= weight; j++) {
        sumYX = sumX + j * y;
        int sum = sumYX;
        for (int k = 0; sum <= weight; k++) {
          sum = sumYX + k * z;
          if (sum == weight) {
            count++;
            break;
          }
        }
      }
    }


    return count;
  }

  private static int solve0(int x, int y, int z, int weight) {
    int count = 0;

    for (int i = 0; i * x <= weight; i++) {
      for (int j = 0; j * y + i * x <= weight; j++) {
        int currentSum = i * x + j * y;
        int left = weight - currentSum;

        if (left >= 0 && left % z == 0) {
          count++;
        }
      }
    }


    return count;
  }
}
