class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
    private void merge(int[] arr, int st, int mid, int end){
        int l= mid-st+1;
        int r=end-mid;
        int[] left=new int[l];
        int[] right=new int[r];
        int k=st;
        for(int i=0;i<l;i++){
            left[i]=arr[k++];
        }
        for(int i=0;i<r;i++){
            right[i]=arr[k++];
        }
        int i=0;
        int j=0;
        k=st;
        while(i<l && j<r){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }else{
                arr[k++]=right[j++];
            }
        }
        while(i<l){
            arr[k++]=left[i++];
        }
        while(j<r){
            arr[k++]=right[j++];
        }
    }
}