class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        int[] tempArr=new int[arr.length];
        for(int element:arr)    tempArr[--element]++;
        List<Integer> list=new ArrayList<>();
        for(int element:tempArr)    list.add(element);
        return list;
    }
}
