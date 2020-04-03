import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }
    
    public void pop() {
        int x = stack1.pop();
        if (stack2.peek() == x) stack2.pop();

        // 下面为什么会报错呢？
        // 对于 peek() 函数的返回值并不是 int 类型，而是一个 Object 类型，
        // 这是一个基本的对象类型，如果直接用双等号 == 来比较的话，肯定不会返回 true，因为是两个不同的对象，所以一定要先将一个转为 int 型，然后再和另一个进行比较
        // if (stack1.peek() == stack2.peek()) {
        //     stack2.pop();
        // }
        // stack1.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

