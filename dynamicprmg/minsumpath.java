package dp;
import java.util.*;
public class minsumpath {
    public static void main(String[] args) {
        int arr[][] = {
            {1,2,3},
            {4,5,4},
            {7,5,9}
        };
        int dp[][] = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], -1);
        int r = arr.length; int c = arr[0].length;
        System.out.println(dpsol2(r-1,c-1,arr, dp));
    }
    static int sol(int r, int c, int[][] arr) {

        if(r == 0 && c == 0) return arr[r][c];
        if(r < 0 || c < 0) return Integer.MAX_VALUE;
        int cur = arr[r][c];
        int up = sol(r-1, c, arr);
        int left = sol(r, c-1, arr);
        return cur + Integer.min(up,left);
    }
    
    static int dpsol(int r, int c, int[][] arr, int[][] dp) {
        
        if(r == 0 && c==0 ) return dp[r][c] = arr[r][c];
        if(r < 0 || c < 0) return Integer.MAX_VALUE;
        if(dp[r][c] != -1) return dp[r][c];
        
        int cur= arr[r][c];
        int up = dpsol(r-1, c, arr, dp);
        int left = dpsol(r, c-1, arr, dp);
        return dp[r][c] = cur + Integer.min(up,left);
    }

    static int dpsol2(int r, int c, int[][]arr, int[][] dp) {

        int i, j, up, left;

        for(i=0; i<arr.length; i++) {
            for(j=0; j<arr[0].length; j++) {
                if(i==0 && j==0) { dp[i][j] = arr[i][j]; continue; }

                up = Integer.MAX_VALUE;
                left = Integer.MAX_VALUE;
                
                if(i != 0) up = dp[i-1][j];
                if(j != 0) left = dp[i][j-1];

                dp[i][j] = arr[i][j] + Integer.min(up,left);

            }
        }

        return dp[r][c];
        

    }
}
