package main.java.com.algorithms.leetCode.backTracking;

public class wordSearch {

    public static boolean helper(char[][] board, String word, int row, int col, int index) {
        if(index >= word.length())
            return true;

        if(row < 0 || row == board.length || col < 0 || col == board[0].length)
            return false;

        boolean ret = false;

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        for(int d = 0; d < 4; d++) {
            ret = helper(board, word, row + rowOffsets[d], col + colOffsets[d], index + 1);
            if(ret)
                break;
        }

        board[row][col] = word.charAt(index);
        return ret;
    }


        public static boolean exist(char[][] board, String word) {

            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == word.charAt(0)) {
                        return helper(board, word, i, j, 1);
                    }
                }
            }
        return false;
    }


    public static void main(String[] args) {

        System.out.println("Word search problem input: ");

        char[][] board = { { 'A', 'B', 'C', 'E' } , {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.println(""+ board);
        System.out.println("word: "+ word);

        System.out.println("boolean output: "+ exist(board, word));
    }
}
