package dp;
import java.util.*;
public class longestincreasingsubsequence {
    public static void main(String[] args) {
        int arr[] = {5,4,11,1,16,8};
        int ans = sol(arr);
        System.out.println(ans);
    }
    static int sol(int arr[]) {
        int n = arr.length; 
        int[] dp = new int[n];
        int[] prev= new int[n];
        int previ = -1; Arrays.fill(prev, -1);
        Arrays.fill(dp, 1);
        int i, prevind, tempmax=-1, ansind = 0;

        for(i=0; i<n; i++) {
            for(prevind = 0, tempmax = previ = -1; prevind < i; prevind++) {

                if(arr[prevind] < arr[i]) {

                    if(tempmax < dp[i] + dp[prevind]) previ = prevind;
                    tempmax = Integer.max(tempmax, dp[i] + dp[prevind]);

                    
                }
            }
            if(tempmax != -1) {
                dp[i] = tempmax;
                prev[i] = previ; 
            }
            if(dp[i] > dp[ansind]) ansind = i;
        }

        System.out.println(Arrays.toString(prev));
        return ansind;
    }
}
