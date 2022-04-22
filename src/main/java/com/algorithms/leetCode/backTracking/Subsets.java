package main.java.com.algorithms.leetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets{

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

       dfs(result, current, nums, 0);

        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> current, int[] nums, int currentNumber) {
        if(currentNumber == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        // Add the current number to subset
        current.add(nums[currentNumber]);
        dfs(result, current, nums, currentNumber + 1);

        current.remove(current.size() - 1);
        dfs(result, current, nums, currentNumber + 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();

        System.out.println("List of subsets: "+ result);

        result = findSubsets(new int[] {1, 5, 3});
        System.out.println("List of subsets: "+ result);
    }
}