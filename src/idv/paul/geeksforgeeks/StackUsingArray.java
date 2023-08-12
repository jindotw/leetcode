package idv.paul.geeksforgeeks;

public class StackUsingArray {
    int top;
    int[] arr = new int[1000];

    StackUsingArray() {
        top = -1;
    }

    //Function to push an integer into the stack.
    void push(int a) {
        if (top < arr.length) {
            arr[++top] = a;
        }
    }

    //Function to remove an item from top of the stack.
    int pop() {
        return top < 0 ? -1 : arr[top--];
    }

    public static void main(String... argv) {
        StackUsingArray obj = new StackUsingArray();
        System.out.println(obj.pop());
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }

}
