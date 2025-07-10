/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // code here
        if(head.next==null) return head;
        Node headNext=head.next;
        if(x==1){
            headNext.prev=null;
            head.next=null;
            return headNext;
        }
        int cnt=1;
        x-=1;
        Node temp=head;
        while(cnt!=x){
            temp=temp.next;
            cnt++;
        }
        if(temp.next.next!=null){
            temp.next.next.prev=temp;
        }
        temp.next=temp.next.next;
        return head;
    }
}