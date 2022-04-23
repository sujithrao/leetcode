package main.java.com.algorithms.leetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSums {

    public static void helper(int[] candidates, List<Integer> current, List<List<Integer>> result, int target, int total, int iteration) {

        if(target == total) {
            result.add(new ArrayList<>(current));
            return;
        }

        if(total > target || iteration >= candidates.length)
            return;

        current.add(0, candidates[iteration]);

        helper(candidates, current, result, target, total + candidates[iteration], iteration);

        current.remove(0);
        helper(candidates, current, result, target, total, iteration + 1);

    }

    public static List<List<Integer>> combinationSums(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(candidates, current, result, target, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Combination sums");
        List<List<Integer>> result = new ArrayList<>();
        result = combinationSums(new int[] {2,3,6,7}, 7);

        System.out.println("Combination results :" + result);
    }
}
