class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int w) {
        // code here
        int size=values.length;
        double[][] arr=new double[size][2];
        for(int i=0;i<size;i++){
            arr[i][0]=i;
            arr[i][1]=(double)values[i]/weights[i];
        }
        Comparator<double[]> com=new Comparator<>(){
            public int compare(double[] a, double[] b){
                if(a[1]>b[1])   return -1;
                else if(a[1]<b[1])  return 1;
                else return 0;
            }
        };
        Arrays.sort(arr,com);
        double maxi=0;
        double W=w;
        for(int i=0;i<size;i++){
            if(W>=weights[(int)arr[i][0]]){
                maxi+=values[(int)arr[i][0]];
                W-=weights[(int)arr[i][0]];
            }else if(W>0){
                maxi+=W/weights[(int)arr[i][0]]*values[(int)arr[i][0]];
                break;
            }
        }
        return maxi;
    }
}