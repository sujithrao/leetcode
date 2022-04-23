package main.java.com.algorithms.leetCode.backTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    // [1, 2, 2]

    public static void helper(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {

        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            helper(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> subsetWithDups(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(result, current, nums, 0);
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,2};
        Arrays.sort(nums);
        System.out.println("Input array: "+ nums);

        subsetWithDups(nums);
        System.out.println("Result List: "+ subsetWithDups(nums));
    }
}
