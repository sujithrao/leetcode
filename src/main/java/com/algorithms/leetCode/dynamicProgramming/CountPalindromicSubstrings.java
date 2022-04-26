package main.java.com.algorithms.leetCode.dynamicProgramming;

public class CountPalindromicSubstrings {

    public static int countSubStrings(String input) {

        int counter = 0;

        for(int i = 0; i < input.length(); i++) {
            int left = i;
            int right = i;
            while(left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
                counter++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while(left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
                counter++;
                left--;
                right++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        String input = "abc";

        System.out.println("input: "+ input);

        int count = countSubStrings(input);

        System.out.println("output:" + count);
    }
}
