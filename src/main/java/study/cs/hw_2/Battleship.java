package study.cs.hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Battleship {

  public static void main(String[] args) {
    try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
      String[] input = reader.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      int[][] map = new int[n][m];

      for (int i = 0; i < n; i++) {
        map[i] = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
      }

      String output = "%.6f".formatted(countShips(map) / (n * m));
      System.out.println(output);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }


  }

  private static double countShips(int[][] map) {
    int ships = 0;

    for (int[] subMap : map) {
      for (int position : subMap) {
        if (position == 1) {
          ships++;
        }
      }
    }

    return ships;
  }

}
