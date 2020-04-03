import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {

    class Entry {
        int key;
        int value;
        Entry newer;
        Entry older;
        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.older = null;
            this.newer = null;
        }
    }

    int size = 0;
    int capacity;
    Entry head = null;
    Entry tail = null;
    // 构造双向链表维护使用情况，最新使用放在tail，最少使用放在head
    HashMap<Integer, Entry> _keymap = new HashMap<Integer, Entry>();
    
    // 构造函数
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Entry entry = _keymap.get(key);
        if (entry == null) return -1;
        this._markEntryAsUsed(entry);
        return entry.value;
    }
    
    public void put(int key, int value) {
        Entry entry = _keymap.get(key);
        if(entry != null) {
            // update existing
            entry.value = value;
            this._markEntryAsUsed(entry);
            return;
        }
        // 新entry, 接在末尾
        Entry newEntry = new Entry(key, value);
        _keymap.put(key, newEntry);

        if (tail != null) {
            tail.newer = newEntry;
            newEntry.older = tail;
        } else {
            head = newEntry;
        }

        tail = newEntry;
        size++;
        if (size > this.capacity) {
            this.shift();
        }
    }

    private void _markEntryAsUsed(Entry entry) {
        if (entry == tail) {
            return;
        }
        if (entry.newer != null) {
            if (entry == head) {
                head = entry.newer;
            }
            entry.newer.older = entry.older;
        }

        if (entry.older != null) {
            entry.older.newer = entry.newer;
        }
        entry.newer = null;
        entry.older = tail;
        if (tail != null) {
            tail.newer = entry;
        }
        tail = entry;
    }

    // 删除head
    private void shift() {
        Entry entry = head;
        if (entry != null) {
            if (head.newer != null) {
              head = head.newer;
              head.older = null;
            } else {
                // the cache is exhausted
                head = null;
                tail = null;
            }
            entry.newer = entry.older = null;
            _keymap.remove(entry.key);
            size--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

