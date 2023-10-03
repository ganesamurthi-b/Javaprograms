package dp;
import java.util.*;

public class triangleminsum {
    public static void main(String[] args) {
        int arr[][] = {
            {1,0,0,0},
            {2,3,0,0},
            {3,6,7,0},
            {8,9,6,10}
        };
        int n = 4;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        //System.out.println(dpsol(0, 0, n-1, arr, dp));
        System.out.println(dpsol2(n-1, arr, dp));
    }    
    static int sol(int i, int j, int n, int arr[][]) {
        if(i == n) return arr[i][j];
        int straightdown = sol(i+1, j, n, arr); int rightdown = sol(i+1, j+1, n, arr);
        return arr[i][j] + Integer.min(straightdown, rightdown );
    }
    
    static int dpsol(int i, int j, int n, int arr[][], int dp[][]) {
        if(i == n) return dp[i][j] = arr[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int straightdown = dpsol(i+1, j, n, arr, dp);
        int rightdown = dpsol(i+1, j+1, n, arr, dp);
        return dp[i][j] = arr[i][j] + Integer.min( straightdown, rightdown );
    }

    static int dpsol2(int n, int arr[][], int dp[][]) {
        int i, j;
        for(int k=0; k<4; k++) dp[n][k] = arr[n][k];
        for(i=n-1; i>=0; i--) {
            for(j=0; j<n; j++) {
                dp[i][j] = arr[i][j] + Integer.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
