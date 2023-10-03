// leetcode 79. wordsearch

package rec;
import java.util.*;
public class wordsearch {
    public static void main(String[] args) {

         char board[][] = {
            {'a','b'}
         };
        exist(board, "ba");
    }

    static void exist(char[][] board, String search) {

        boolean path[][] = new boolean[board.length][board[0].length];
        int i, j;
        for(i=0; i<board.length; i++) {
            for(j=0; j<board[0].length; j++) {
                path[i][j] = false;
            }
        }
        String stillans = "";
        boolean ans=false;
        for(i=0; i<board.length; i++) {

            for(j=0; j<board[0].length; j++) {

                if(board[i][j] == search.charAt(0)) {

                    //ans = sol("", board, 0, i, j, search, path);
                }

                //if(ans) return true;

            }
        }
        //return false;
        System.out.println(Arrays.deepToString(path));
        ans = sol("", board, 0, 0, 1, search, path);
        System.out.println(ans);
        
    }
    static boolean sol (String stillans, char[][] board, int sindex, int r, int c, String search, boolean path[][]) {


        if(path[r][c] == true) {
            return false;
        }
        path[r][c] = true;

        if(board[r][c] != search.charAt(sindex)) {
            path[r][c] = false;
            return false;
        }

        stillans = stillans+board[r][c];
        System.out.println(stillans);

        if(stillans.length() == search.length()){
            if(search.equals(stillans)) {
                path[r][c] = false;
                return true;
            }
        path[r][c] = false;
        return false;
        }

        boolean right, left, up, down;
        right = left = up = down = false;

        //check right
        if(r < board.length && c < board[0].length-1) {
            right = sol(stillans, board, sindex+1, r, c+1, search, path);
        }

        //check down
        if(r < board.length-1 && c< board[0].length) {
            down = sol(stillans, board, sindex+1, r+1, c, search, path);
        }

        //check left
        if(r < board.length && c > 0) {
            System.out.println(true);
            left = sol(stillans, board, sindex+1, r, c-1, search, path);
        }
        // check up
        if(r > 1 && c < board[0].length) {
            up  = sol(stillans, board, sindex+1, r-1, c, search, path);
        } 
        path[r][c] = false;

        return (right || left || up || down);
    }
}







 /*     static boolean sol (String stillans, char[][] board, int sindex, int r, int c, String search, boolean path) {
        if(sindex == search.length()-1) {
            if(stillans.equals(search)) return true;
            return false;
        }

        // checking right
        if(r < board.length && c < board[0].length-1) {
            if(board[r][c+1] == search.charAt(sindex+1)){
                return sol(stillans + board[r][c+1], board, sindex+1, r, c+1, search);
            }
        }
        // checking down

        if(r < board.length-1 && c<board[0].length) {
            if(board[r+1][c] == search.charAt(sindex+1)) {
                return sol(stillans+board[r+1][c], board, sindex+1, r+1, c, search);
            }
        }


        // checking left
        if(r < board.length && c > 0) { 
            if(board[r][c-1] == search.charAt(sindex+1)) {
                return sol(stillans + board[r][c-1], board, sindex+1, r, c-1, search);
            }

        }
        // checking up

        if(r > 0 && c < board[0].length) {
            if(board[r-1][c] == search.charAt(sindex+1) ) {
                return sol(stillans + board[r-1][c], board, sindex+1, r-1, c, search);
            }
        }


        return false;

        
    }*/

