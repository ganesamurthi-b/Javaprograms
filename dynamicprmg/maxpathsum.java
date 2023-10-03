// dp-12 maximum falling path sum variable starting and ending points
package dp;
import java.util.*;
public class maxpathsum {
    public static void main(String[] args) {
        int arr[][] = {
            {1,2,10,4},
            {100,3,2,1},
            {1,1,20,2},
            {1,2,2,1}
        };int dp[][] = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[0], -1);
        int max = -1, tempans;
        // for(int i=0; i<arr[0].length; i++) {
        //     dp[arr.length-1][i] = dpsol(arr.length-1, i, arr, dp);
        //     max = Integer.max(dp[arr.length-1][i], max);
        // }

        System.out.println(dpsol2(arr, dp));
    }
    static int sol(int i, int j, int arr[][]) {
        if( i == 0 && (j>=0 && j<arr[0].length) ){ return arr[i][j]; }
        if(i < 0 || j < 0 || j >=arr[0].length) return -1;
        int up, ul, ur;
        
        up = arr[i][j]+sol(i-1, j, arr);
        ul = arr[i][j]+sol(i-1, j-1, arr);
        ur = arr[i][j]+sol(i-1, j+1, arr);
        int ans = Integer.max(up, Integer.max(ul, ur));
        return ans;

    }
    static int dpsol(int i, int j, int[][] arr, int[][] dp) {
        if(i==0 && (j>=0 && j<arr[0].length)) return dp[i][j] = arr[i][j];
        if(i<0 || j<0 || j>=arr[0].length) return -1;
        if(dp[i][j] != -1) return dp[i][j];
        int up, ul, ur;
        up = arr[i][j]+dpsol(i-1, j, arr, dp);
        ul = arr[i][j]+dpsol(i-1, j-1, arr, dp);
        ur = arr[i][j]+dpsol(i-1, j+1, arr, dp);
        return dp[i][j] = Integer.max(up, Integer.max(ul, ur));
    }
    static int dpsol2(int[][] arr, int[][] dp) {
        int i, j, max=-1, up, ul, ur;
        for(i=0; i<arr.length; i++) {
            for(j=0; j<arr[0].length; j++) {
                up = ul = ur = -1;
                if(i == 0) {dp[i][j] = arr[i][j];continue;}
                up = arr[i][j] + dp[i-1][j];
                if(j > 0) ul = arr[i][j] + dp[i-1][j-1];
                if(j+1 < arr[0].length) ur = arr[i][j] + dp[i-1][j+1];
                dp[i][j] = Integer.max(up, Integer.max(ul,ur));
            }
        }
        for(i=0; i<arr[0].length; i++) {
            max = Integer.max(max, dp[arr.length-1][i]);
        }
        return max;
    }
}
