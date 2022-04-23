package main.java.com.algorithms.leetCode.backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void helper(List<List<Integer>> result, List<Integer> current, int index) {

        if(current.size() == index) {
            result.add(new ArrayList<>(current));
        }
        for(int i = index; i < current.size(); i++) {
            Collections.swap(current,index, i);
            helper(result, current, index + 1);
            Collections.swap(current, index, i);
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int num : nums) {
            current.add(num);
        }
        helper(result, current, 0);
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
