package main.java.com.algorithms.leetCode.hashTable;

import java.util.HashMap;

public class EncodeDecodeTinyURL {

    static String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static HashMap<String, String> map = new HashMap<>();
    static int count = 1;

    public static String encode(String input) {
        String key = getString();
        map.put(key, input);
        count++;
        return "http://tinyurl.com/" + key;
    }

    public static String getString() {
        int c = count;
        StringBuilder sb = new StringBuilder();
        while ( c > 0) {
            c--;
            sb.append(chars.charAt(c % 62));
            c = c / 62;
        }
        return sb.toString();
    }

    public static String decode(String input) {

        return map.get(input.replace("http://tinyurl.com/", ""));
    }

    public static void main(String[] args) {
        String input = "https://leetcode.com/problems/design-tinyurl";

        System.out.println("Input Url: "+ input);

        String tinyUrl = encode(input);
        System.out.println("Tiny Url: "+ tinyUrl);

        String originalUrl = decode(tinyUrl);
        System.out.println("Original Url:" + originalUrl);

    }
}
