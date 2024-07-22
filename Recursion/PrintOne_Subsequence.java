import java.util.*;

class PrintOne_Subsequence{
      public static void main(String[] args) {
            int[]nums={1,2,1};
            int index=0;
            int s=2;
            int sum=0;
            List<Integer>list=new ArrayList<>();
            if(printOne(nums, index, sum, s,list))
            System.out.println("Yes");

      }
      static boolean printOne(int[]nums,int index,int sum,int s,List<Integer>list){
            if(index==nums.length){
                  if(s==sum){
                        for(int i=0;i<list.size();i++){
                              System.out.print(list.get(i)+" ");
                        }
                        return true;
                  }
                  else
                  return false;
            }
            list.add(nums[index]);
            sum+=nums[index];
            if(printOne(nums, index+1, sum, s, list)==true){
                  return true;
            }
            sum-=nums[index];
            list.remove(list.size()-1);
            if(printOne(nums, index+1, sum, s, list)==true){
                  return true;
            }
            return false;
      }
}