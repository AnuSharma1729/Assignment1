/*package whatever //do not write package name here */

import java.io.*;

class TwoSum {
	public static void main (String[] args) {
// 		Time Complexity: o(n);
// 		Space Complexity: o(n);

        int[] ans = new int[]{};
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i= 0; i< nums.length; ++i){
            map.put(nums[i],i);
        }
        
        for(int i = 0; i < nums.length; ++i){
            int val = target - nums[i];
            if(map.containsKey(val) && map.get(val) != i){
                ans = new int[]{i,map.get(val)};
                break;
            }
        }
        
        
        return ans;
		
	}
}