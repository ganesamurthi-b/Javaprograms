import java.util.*;
public class maxpathsum {
    public static void main(String[] args) {
        int[][] arr = {
        {1, 2, 10, 4},
        {100, 3, 2, 1} ,
        {1, 1, 20, 2},
        {1, 2, 2, 1}};
        int dp[][] = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], -1);

        sol(arr, dp);

    }

    static int sol(int arr[][], int dp[][]) {

        int i,j;
        int up, ul, ur;
        up = ul = ur = -1;
        for(i=0; i<arr[0].length; i++) {dp[0][i] = arr[0][i];}
        for(i=1; i<arr.length; i++) {
            for(j=0; j<arr[0].length; j++) {
                up = ul = ur = -1;
                up = dp[i-1][j];
                if(j > 0) ul = dp[i-1][j-1];
                if(j < arr[0].length-1) ur = dp[i-1][j+1];

                dp[i][j] = arr[i][j] + Integer.max(up, Integer.max(ul, ur));
            }        
        }

        for(i=0; i<dp.length; i++) System.out.println(Arrays.toString(dp[i]));
        return 1;
    }

}
