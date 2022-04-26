package main.java.com.algorithms.leetCode.dynamicProgramming;

public class PalindromicSubstring {

    public static String result = null;
    public static int max = Integer.MIN_VALUE;

    public static String longestPalindrome(String input) {
        if(input == null)
            return null;
        int longestSubString = 0;
        for(int i = 0; i < input.length(); i++) {

            helper(input, i, i);
            helper(input, i, i + 1);
        }

        return result;
    }

    public static void helper(String input, int left, int right) {
        while(left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            if((right - left + 1) > max) {
                result = input.substring(left, right + 1);
                max = right - left + 1;
            }
            left--;
            right++;
        }
    }



    public static void main(String[] args) {
        String input = "cbbd";
        System.out.println("Palindrome: ");
        System.out.println("input string: "+ input);

        String result = longestPalindrome(input);

        System.out.println("Longest substring: "+ result);
    }
}
