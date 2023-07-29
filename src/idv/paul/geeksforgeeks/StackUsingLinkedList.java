package idv.paul.geeksforgeeks;

public class StackUsingLinkedList {
     class StackNode {
         int data;
         StackNode next;

         StackNode(int a) {
             data = a;
             next = null;
         }
     }

    StackNode top;

     void push(int a) {
         StackNode node = new StackNode(a);
         node.next = top;
         top = node;
     }

     int pop() {
         int val = -1;
         if (top != null) {
             val = top.data;
             top = top.next;
         }

         return val;
     }

     public static void main(String... argv) {
         StackUsingLinkedList obj = new StackUsingLinkedList();
         obj.push(2);
         obj.push(3);
         System.out.println(obj.pop());
         obj.push(4);
         System.out.println(obj.pop());
         System.out.println(obj.pop());
         System.out.println(obj.pop());
     }
}
