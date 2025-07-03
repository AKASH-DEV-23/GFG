// User function Template for Java

class Solution {
    public void immediateSmaller(int arr[]) {
        // code here
        int size=arr.length-1;
        Stack<Integer> st=new Stack<>();
        st.push(arr[size]);
        arr[size--]=-1;
        while(size>=0){
            int temp=arr[size];
            if(st.peek()<temp)    arr[size]=st.peek();
            else    arr[size]=-1;
            st.pop();
            st.push(temp);
            size--;
        }
    }
}