class Solution {
    public int[] leftSmaller(int[] arr) {
        // code here
        int idx=0;
        Stack<Integer> st=new Stack<>();
        while(idx<arr.length){
            int temp=arr[idx];
            while(!st.isEmpty() && st.peek()>=temp) st.pop();
            if(st.isEmpty())    arr[idx]=-1;
            else    arr[idx]=st.peek();
            st.push(temp);
            idx++;
        }
        return arr;
    }
}
