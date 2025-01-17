import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {
    private boolean[] hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.hashSet = new boolean[1000001];
    }
    
    public void add(int key) {
        hashSet[key] = true;
    }
    
    public void remove(int key) {
        hashSet[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashSet[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

