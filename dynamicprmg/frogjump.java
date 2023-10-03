package dp;
import java.util.*;
public class frogjump {
    public static void main(String[] args) {

        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        //System.out.println(dpsol(0,n,1,new int[]{10,20,30,10}, dp));
        System.out.println(sol(0,n,1,new int[]{10,20,30,10}));
    }

    static int sol(int diff, int n, int index, int heights[]) {
        if(index == n) {
            return diff;
        }
        if(index > n) {
            return Integer.MAX_VALUE;
        }
        int diff1 = Integer.MAX_VALUE, diff2=Integer.MAX_VALUE;
        diff1 = (int) Math.abs(heights[index-1] - heights[(index+1)-1]);
        if(index + 2 <= n){
            diff2 = (int) Math.abs(heights[index-1] - heights[(index+2)-1]);
        }
        diff1+=diff; diff2+=diff;
        int ans = Math.min( sol(diff1, n, index+1, heights), sol(diff2, n, index+2, heights) );

        return ans;
    }

    static int dpsol(int diff, int n, int index, int[] heights, int[] dp) {
        if(index == n) {
            return diff;
        }
        if(index > n) {
            return Integer.MAX_VALUE;
        }

        if(dp[index] > -1) {
            return diff+dp[index];
        }

        int diff1, diff2=0;
        diff1 = (int) Math.abs(heights[index-1] - heights[(index+1-1)]);
        if(index + 2 <= n) {
            diff2 = (int) Math.abs(heights[index-1] - heights[(index+2 -1)]);
        }

        dp[index] = Math.min( dpsol(diff1, n, index+1, heights, dp), dpsol(diff2, n, index+2, heights, dp));
        return dp[index] + diff;        
    }

    static int dptab (int n, int[] heights) {
        int dp[] = new int[n+1];

        dp[0] = 0;
        int i;
        for(i = 1; i < n; i++) {
            int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1) ss = dp[i-2]  + Math.abs(heights[i] - heights[i-2]);

            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }
}