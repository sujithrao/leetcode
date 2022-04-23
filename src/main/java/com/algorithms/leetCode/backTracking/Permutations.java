package main.java.com.algorithms.leetCode.backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void helper(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {

        if(nums.length == index) {
            result.add(new ArrayList<>(current));
            for(int i = index; i < nums.length; i++) {
                swap(nums,index, i);
                current.add(nums[i]);
                helper(result, current, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    public static void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(result, current, nums, 0);
        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();
        System.out.println("Input nums:"+ nums);

        result = permute(nums);
        System.out.println("Output list: "+ result);
    }
}
