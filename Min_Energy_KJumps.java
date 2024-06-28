import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[]nums={20,40,60,40,10};
        int[]dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        System.out.println(optimization(nums,nums.length-1));
        
    }
    //General Way
    public static int find(int[]nums,int index){
        if(index==0)
        return 0;
        int left=nums[index-1]+Math.abs(nums[index]-nums[index-1]);
        int right=Integer.MAX_VALUE;
        if(index>1){
            right=nums[index-2]+Math.abs(nums[index]-nums[index-2]);
        }
        return Math.min(left,right);
    }
    
    //Memoization Method
    public static int memo(int[]dp,int[]nums,int index){
        if(index==0)
        return 0;
        if(dp[index]!=-1)
        return dp[index];
        int left=memo(dp,nums,index-1)+Math.abs(nums[index]-nums[index-1]);
        int right=Integer.MAX_VALUE;
        if(index>1){
            right=memo(dp,nums,index-2)+Math.abs(nums[index]-nums[index-2]);
        }
        return dp[index]=Math.min(left,right);
    }
    
    
    //Tabulation Method
    public static tabulation(int[]dp,int []nums){
        dp[0]=0;
        for(int i=1;i<nums.length;i++){
            int left=dp[i-1]+Math.abs(nums[i]-nums[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1){
                right=dp[i-2]+Math.abs(nums[i-2]-nums[i]);
            }
            dp[i]=Math.min(left,right);
        }
        return dp[nums.length-1];
    }
    
    //Space Optimization
    public static int optimization(int[]nums,int index){
        int prev=0;
        int prev2=0;
        for(int i=1;i<nums.length;i++){
            int fs=prev+Math.abs(nums[i]-nums[i-1]);
            int ss=Integer.MAX_VALUE;
            if(i>1)
            ss=prev2+Math.abs(nums[i]-nums[i-2]);
            int curr=Math.min(fs,ss);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}