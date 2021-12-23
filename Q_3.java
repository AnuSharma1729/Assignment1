/*package whatever //do not write package name here */

import java.io.*;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        
        if(S > sum || (S + sum) % 2 != 0) return 0;
        
        int r = (S + sum)/2;
        
        int[][] dp = new int[nums.length+1][r+1];
        
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j< dp[0].length; ++j){
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = 0;
                else{
                    if(nums[i-1] > j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j]= dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    }
                }
            }
        }
        return dp[nums.length][r];
    }
    
}