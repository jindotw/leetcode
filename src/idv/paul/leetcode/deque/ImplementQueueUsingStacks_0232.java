package idv.paul.leetcode.deque;

/*
https://leetcode.com/problems/implement-queue-using-stacks/
232. Implement Queue using Stacks
Easy
6.5K
371
Companies
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

Related Topics
Stack
Design
Queue
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks_0232 {
	Deque<Integer> st1;
	Deque<Integer> st2;

	public ImplementQueueUsingStacks_0232() {
		st1 = new ArrayDeque<>();
		st2 = new ArrayDeque<>();
	}

	public void push(int x) {
		st1.push(x);
	}

	public int pop() {
		while (!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		int val = st2.pop();
		while (!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		return val;
	}

	public int peek() {
		while (!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		Integer val = st2.peek();
		while (!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		return val == null ? 0 : val;
	}

	public boolean empty() {
		return st1.isEmpty();
	}

	public static void main(String ...argv) {
		ImplementQueueUsingStacks_0232 queue = new ImplementQueueUsingStacks_0232();
		System.out.println(queue.empty());
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		System.out.println(queue.empty());
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
