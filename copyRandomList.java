/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        //MERGE BOTH LISTS
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        
        //CREATING RANDOM POINTER 
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node currHead = head.next; 
        curr = head;
        Node currCopy = currHead;
        //SLPLITING BOTH THE LISTS
        while(curr != null){
            curr.next = curr.next.next;
            if(curr.next != null){
                currCopy.next = currCopy.next.next;
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return currHead;
    }
}
