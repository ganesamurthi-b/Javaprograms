import java.util.*;
public class ninjatraining {
    public static void main(String[] args) {
        int days = 3;
        int[][] arr = {
            {10,40,70},
            {20,50,80},
            {30,60,90}
        };
        int[][] dp = new int[arr.length][arr[0].length+1];
        int ans = sol(arr, arr.length-1, 3);
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], -1);
        System.out.println(ans);

        dpsol(arr, 2, 0, dp);
        
    }
    static int sol(int arr[][], int days, int prev) {

        if(days == 0) {
            int i, max=Integer.MIN_VALUE;
            for(i=0; i<arr[0].length; i++) {
                if(i!=prev)
                    max = Integer.max(arr[days][i], max);
            }
            return max;
        }
        int i, max = Integer.MIN_VALUE, temp;
        for(i=0; i<arr[0].length; i++) {
            if(i!=prev) {
                temp = arr[days][i] + sol(arr, days-1, i);
                max = Integer.max(max, temp);
            }
        }
        return max;
    }
    static int dpsol(int arr[][], int days, int prev, int dp[][]) {
        dp[0][0] = Integer.max(arr[0][1], arr[0][2]);
        dp[0][1] = Integer.max(arr[0][0], arr[0][2]);
        dp[0][2] = Integer.max(arr[0][0], arr[0][1]);
        dp[0][3] = Integer.max(arr[0][0], Integer.max(arr[0][1], arr[0][2]));

        int i, j, last, max, temp;

        for(i=1; i<=days; i++) {

            for(last=0; last<=3; last++) {

                max = -1;

                for(j=0; j<arr[0].length; j++) {

                    if(j != last) {

                        temp = arr[i][j] + dp[i-1][j];
                        max = Integer.max(max, temp);
                    }
                }
                dp[i][last] =  max;
            }
        }
        for(i=0; i<=2; i++) System.out.println(Arrays.toString(dp[i]));
        return 0;
    }
}