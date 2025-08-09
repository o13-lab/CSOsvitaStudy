package study.cs.hw_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MajorityElement {

  public int majorityElement(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == nums[i]) {
          count++;
          if (count > nums.length / 2) {
            return nums[i];
          }
        }
      }
    }
    return nums[0];
  }


  public int majorityElement2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      if (map.get(num) > nums.length / 2) {
        return num;
      }
    }

    return nums[0];
  }

  public int majorityElement3(int[] nums) {
    int num = nums[0];
    int count = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == num) {
        count++;
      } else {
        count--;
        if (count == 0) {
          num = nums[i];
          count = 1;
        }
      }
    }

    return num;
  }

  private Random random = new Random();

  public int majorityElement4(int[] nums) {
    int candidate = random.nextInt(nums.length);

    while (true) {
      iterations++;
      int count = computeFrequency(nums, nums[candidate]);
      if (count > nums.length / 2) {
        return nums[candidate];
      }
      candidate = random.nextInt(nums.length);
    }
  }

  private int computeFrequency(int[] nums, int num) {
    int count = 0;
    for (int n : nums) {
      if (n == num) {
        count++;
      }
    }
    return count;
  }

  int iterations = 0;

  public static void main(String[] args) {
    var majorityElement = new MajorityElement();

    for (int i = 10; i <= 1_000_000; i *= 10) {
      int[] nums = majorityElement.generateArray(i);

      majorityElement.majorityElement4(nums);

      System.out.println("Array size: " + i + ", Iterations: " + majorityElement.iterations);
      majorityElement.iterations = 0;
    }
  }

  private int[] generateArray(int i) {
    var array = new int[i];

    List<Integer> list = new ArrayList<>();
    for (int j = 0; j < i; j++) {
      list.add(j);
    }

    int[] randomNumbers = this.random.ints(0, 1000 ).limit(i / 2 - 1).toArray();

    for (int num : randomNumbers) {
      int index = this.random.nextInt(0, list.size());
      int randomIndex = list.remove(index);
      array[randomIndex] = num;
    }

    return array;
  }

}
