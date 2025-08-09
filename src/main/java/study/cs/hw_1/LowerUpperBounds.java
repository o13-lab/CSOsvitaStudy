package study.cs.hw_1;

import java.util.Arrays;

public class LowerUpperBounds {

  int counter = 0;

  public static void main(String[] args) {
    LowerUpperBounds lowerUpperBounds = new LowerUpperBounds();
    for (int i = 1; i <= 10; i *= 2) {
      System.out.println("Permutations of " + i + " elements:");
      lowerUpperBounds.permute(new int[0], i);
      System.out.println("Total permutations: " + lowerUpperBounds.counter);
      lowerUpperBounds.counter = 0;
    }
//    lowerUpperBounds.permute(new int[0], 5);
//    System.out.println("Total permutations: " + lowerUpperBounds.counter);
  }

  void permute(int[] prefix, int n) {
    if (prefix.length == n) {
//      System.out.println(Arrays.toString(prefix));
      counter++;
      return;
    }

    for (int num = 0; num < n; num++) {
      if (!contains(prefix, num)) {
        int[] newPrefix = Arrays.copyOf(prefix, prefix.length + 1);
        newPrefix[newPrefix.length - 1] = num;
        permute(newPrefix, n);
      }
    }
  }

  private boolean contains(int[] prefix, int num) {
    for (int value : prefix) {
      if (value == num) {
        return true;
      }
    }
    return false;
  }
}
