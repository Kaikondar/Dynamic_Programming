class Count_SubSequences{
      public static void main(String[] args) {
            int[]nums={1,2,1,2,1};
            System.out.println(count(nums, 0, 0, 2));
      }
      static int count(int[]nums,int index,int sum,int s){
            if(index==nums.length){
            if(sum==s){
                  return 1;
            }else 
            return 0;
          }
          sum+=nums[index];
          int l=count(nums, index+1, sum, s);
          sum-=nums[index];
          int r=count(nums, index+1, sum, s);
          return l+r;   
      }
}