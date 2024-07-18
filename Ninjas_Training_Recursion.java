/* Question : There are Three tasks in one day and ninja can do any one of the task. 
Each task he gained the points. One important constraint is ninja can not do the today task in next day.
How ninja can gain more points */

class Ninjas_Training_Recursion{
      public static void main(String[] args) {
            int[][]tasks={
                  {1,2,3},
                  {4,5,6},
                  {7,8,9}
            };
            int maxPoints=find(tasks.length-1, 3, tasks);
            System.out.println(maxPoints);
      }
      static int find(int day,int last,int[][]points){
            if(day==0){
               int max=0;
               for(int i=0;i<3;i++){
                  if(i!=last){
                        max=Math.max(points[0][last],max);
                  }
               }
               return max;
            }
            int maxi=0;
            for(int i=0;i<3;i++){
                  if(i!=last){
                        int point=points[day][i]+find(day-1,i,points);
                        maxi=Math.max(maxi,point);
                  }
            }
            return maxi;
      }
}