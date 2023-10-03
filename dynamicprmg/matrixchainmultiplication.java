import java.util.*;
//  A1 A2 A3 A4;
public class Main
{
	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};
		int[][] dp = new int[arr.length][arr.length];
		for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1); int steps, mini = Integer.MAX_VALUE;
		//int ans = sol(1, arr.length-1, arr, dp);
		//System.out.println(ans);
 		for(int i=0; i<dp.length; i++) dp[i][i] = 0;
 		for(int i = arr.length-1; i>=1; i--) {
 		    
 		    for(int j=i+1; j < arr.length; j++) {
 		        mini = Integer.MAX_VALUE;
 		        for(int k = i; k < j; k++) {
 		            
 		            steps = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
 		            mini = Integer.min(mini, steps);
 		        }
 		        dp[i][j] = mini;
 		    }
 		}
 		System.out.println(dp[1][arr.length-1]);
 				for(int i=1; i<dp.length; i++) {
		    for(int j=1; j<dp[0].length; j++) {
		        System.out.print(dp[i][j] + " ");
		    }
		    System.out.println();
 		}
	}
	
	static int sol(int i, int j, int[public class matrixchainmultiplication {
        
    }
    ] arr, int[][] dp) {
	    if(dp[i][j] != -1) return dp[i][j];
	    if(i==j) return dp[i][j] = 0;
	    
	    int k, ans, mini = Integer.MAX_VALUE;
	    
	    for(k = i; k < j; k++) {
	        
	        ans = sol(i, k, arr, dp) + sol(k+1, j, arr, dp) + ( arr[i-1]* arr[k]* arr[j]);
	        mini = Integer.min(mini, ans);
	    }
	    return dp[i][j] = mini;
	    
	}
}
