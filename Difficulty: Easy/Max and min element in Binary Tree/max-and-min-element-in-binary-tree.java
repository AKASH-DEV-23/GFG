/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    static int mini;
    static int maxi;
    public static int findMax(Node root) {
        // code here
        mini=Integer.MAX_VALUE;
        maxi=Integer.MIN_VALUE;
        inorder1(root);
        return maxi;
    }
    private static void inorder1(Node root){
        if(root==null)  return;
        inorder1(root.left);
        maxi=Math.max(maxi,root.data);
        mini=Math.min(mini,root.data);
        inorder1(root.right);
    }

    public static int findMin(Node root) {
        
        // code here
        return mini;
    }
}