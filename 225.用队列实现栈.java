import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
    Queue<Integer> q;
    // 还需要一个队列来永远保持最后一个
    Queue<Integer> tailQ;
    /** Initialize your data structure here. */
    public MyStack() {
        this.q = new LinkedList<Integer>();
        this.tailQ = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // System.out.print(this.q);
        if (this.tailQ.size() > 0) {
            int top = this.tailQ.poll();
            this.q.add(top);
        }
        this.tailQ.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int tail = this.tailQ.poll();
        
        int size = this.q.size(); // 3
        if (size > 0) {
            int i = 1;
            while(i < size) {
                this.q.add(this.q.poll());
                i++;
            }
            this.tailQ.add(this.q.poll());
        }
        return tail;
    }
    
    /** Get the top element. */
    public int top() {
        return tailQ.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.q.isEmpty() && this.tailQ.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

