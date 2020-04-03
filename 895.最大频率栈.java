import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=895 lang=java
 *
 * [895] 最大频率栈
 */

// @lc code=start
class FreqStack {
    private Map<Integer, Integer> freq = new HashMap<>();
    List<Stack<Integer>> stacks = new ArrayList<>();
    public FreqStack() {

    }
    
    public void push(int x) {
        int f = 1;
        if (freq.containsKey(x)) {
            f = freq.get(x) + 1;
        }
        freq.put(x, f);
        if (stacks.size() < f) {
            stacks.add(new Stack<>());
        }
        stacks.get(--f).push(x);
    }
    
    public int pop() {
        // 当前出现次数最多的元素的 stack 集合
        Stack<Integer> lastStack = stacks.get(stacks.size() - 1);
        int x = lastStack.pop();

        if (lastStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        freq.put(x, freq.get(x) - 1);
        if (freq.get(x) <= 0) {
            freq.remove(x);
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
// @lc code=end

