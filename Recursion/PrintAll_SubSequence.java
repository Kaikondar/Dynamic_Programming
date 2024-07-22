import java.util.*;

class PrintAll_SubSequence{
      public static void main(String[] args) {
            int[]nums={1,2,1};
            List<Integer>list=new ArrayList<>();
            printAll(nums, list, 0, 0, 2);
      }
      //Print All Subsequences whose sum is equal to the Given Sum
      static void printAll(int[]nums,List<Integer>list,int index,int sum,int s){
            if(index==nums.length){
                  if(s==sum){
                        for(int i=0;i<list.size();i++){
                              System.out.print(list.get(i)+" ");
                        }
                        System.out.println();
                        return;
                  }
                  return;
            }
            list.add(nums[index]);
            sum+=nums[index];
            printAll(nums,list,index+1,sum,s);
            sum-=list.get(list.size()-1);
            list.remove(list.size()-1);
            
            printAll(nums,list,index+1,sum,s);
      }
}