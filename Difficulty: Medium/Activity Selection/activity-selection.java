
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int n=start.length;
        int[][] activities=new int[n][2];
        for(int i=0;i<n;i++){
            activities[i][0]=start[i];
            activities[i][1]=finish[i];
        }
        Comparator<int[]> com=new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[1]<b[1])   return -1;
                else if(a[1]>b[1])  return 1;
                else    return 0;
            }
        };
        Arrays.sort(activities,com);
        int maxActivity=1;
        int last=activities[0][1];
        for(int[] activity:activities){
            if(activity[0]>last){
                maxActivity++;
                last=activity[1];
            }
        }
        return maxActivity;
    }
}
