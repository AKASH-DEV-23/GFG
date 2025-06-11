class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low<high){
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    static int partition(int arr[], int low, int high) {
        
        // your code here
        int pivot=arr[high];
        int j=low;
        for(int i=low;i<high;i++){
            if(arr[i]<pivot){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j++]=temp;
            }
        }
        int temp=arr[j];
        arr[j]=pivot;
        arr[high]=temp;
        return j;
    }
}