package dp;

import java.util.*;

public class ninjatraining {
    public static void main(String[] args) {
        int[][] arr = {
            {10,40,70},
            {20,50,80},
            {30,60,90}
        };   
        int[][] dp = new int[3][4];
        for(int i=0; i<3; i++) Arrays.fill(dp[i], -1);
        //System.out.println(dpsol2(arr, dp));

        dpsol3(arr);
    }
    static int sol(int days, int last, int[][] arr) {

        if(days == 0) {

            int i, max = Integer.MIN_VALUE;
            for(i=0; i<3; i++) {
                if(i != last) {
                    max = Integer.max(arr[days][i], max);
                }
            }
            return max;
        }

        int i, max = Integer.MIN_VALUE, tempans;
        
        for(i=0; i<3; i++) {

            if(i != last) {
                tempans = arr[days][i] + sol(days-1, i, arr);
                max = Integer.max(tempans, max);
            }
        }
        return max;
    }
    static int dpsol(int days, int last, int[][] arr, int[][] dp) {

        if(dp[days][last] != -1) return dp[days][last];

        if(days == 0) {
            int max=-1, i;
            for(i=0; i<arr[0].length; i++) {
                if(i!=last) {
                    max = Integer.max(max,arr[days][i]);
                }
            }
            return dp[days][last] = max;
        }

        int i, max=-1, tempans;

        for(i=0; i<arr[0].length; i++) {
            if(i!=last) {
                tempans = arr[days][i] + dpsol(days-1, i, arr, dp);
                max = Integer.max(tempans, max);
            }
        }
        return dp[days][last] = max;
    }
    
    static int dpsol2(int [][]arr, int[][] dp) {
        int j;
        int i = 0;
        int n = arr.length; int days;
        for(i=0; i<4; i++) {
            int last = i; 
            int max; max = -1;
            for(j=0; j<arr[0].length; j++) {
                if(j != last) {
                    max = Integer.max(arr[0][j], max);
                }
            }
            dp[0][last] = max;
        }
        int last, max=-1, tempans;
        for(days = 1; days < n; days++) {

            //System.out.println('2');
            for(last = 0; last <= 3; last++) {
                max = -1;
                //System.out.println('3');
                for(j=0; j < arr[0].length; j++) {
                    //System.out.println('4');
                    if(last != j) {
                        tempans = arr[days][j] + dp[days-1][j];
                        max = Integer.max(tempans, max);
                    }
                }
                dp[days][last] = max;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[dp.length-1][dp[0].length-1];
    }
    /* int[][] arr = {
            {10,40,70},
            {20,50,80},
            {30,60,90}
        }; */
    static int dpsol3(int arr[][]) {
        
        
        ArrayList<Integer> next, cur;
        next = new ArrayList<>(4); cur = new ArrayList<>(4);

        cur.add(Integer.max(arr[0][1], arr[0][2]));
        cur.add(Integer.max(arr[0][0], arr[0][2]));
        cur.add(Integer.max(arr[0][0], arr[0][1]));
        cur.add(Integer.max(arr[0][1], Integer.max(arr[0][2], arr[0][0])));

        for(int i=0; i<4; i++) next.add(0);

        System.out.println(cur);

        int days, i, max=-1, task, last, tempans;

        for(days = 1; days < arr.length; days++) {

            for(last = 0; last < 4; last++) {
                max = -1;

                for(task = 0; task < 3; task++) {
                    if(last != task) {
                        tempans = arr[days][task] + cur.get(task);
                        max = Integer.max(tempans, max);
                    }
                }
                System.out.println(last +" " + max );
                next.set(last, max);
            }
            for(i=0; i<4; i++) cur.set(i, next.get(i)) ; for(i=0; i<4; i++) next.set(i,0);
        }

        System.out.println(cur.get(3));
        return 0;
        
    }

}
