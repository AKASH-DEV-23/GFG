/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        // Your code here
        Node newNode=new Node(x);
        if(head==null)  return newNode;
        if(p==0){
            newNode.next=head;
            head.prev=newNode;
            return newNode;
        }
        Node temp=head;
        while(p!=0){
            temp=temp.next;
            p--;
        }
        newNode.prev=temp;
        newNode.next=temp.next;
        temp.next=newNode;
        if(newNode.next!=null){
            newNode.next.prev=newNode;
        }
        return head;
    }
}