import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import apple.laf.JRSUIConstants.Hit;

/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU缓存
 */

// @lc code=start
class LFUCache {
    private static final int DEFAULT_MAX_SIZE = 3;
    private int capacity = DEFAULT_MAX_SIZE;
    private Map<Integer, HitRate> cache = new HashMap<Integer, HitRate>();
    private Map<Integer, Integer> KV = new HashMap< Integer, Integer>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer v = KV.get(key);
        if (v != null) {
            HitRate hitRate = cache.get(key);
            hitRate.hitCount += 1;
            hitRate.lastTime = System.nanoTime();
            return v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if ( capacity == 0 ) return;
        Integer v = KV.get(key);
        if (v == null) {
            if (cache.size() == capacity) {
                Integer k = getKickedKey();
                KV.remove(k);
                cache.remove(k);
            }
            cache.put(key, new HitRate(key, 1, System.nanoTime()));
        } else {
            HitRate hitRate = cache.get(key);
            hitRate.hitCount += 1;
            hitRate.lastTime = System.nanoTime();
        }
        KV.put(key, value);
    }

    private Integer getKickedKey() {
        HitRate min = Collections.min(cache.values());
        return min.key;
    }

    class HitRate implements Comparable<HitRate> {
        Integer key;
        Integer hitCount;
        Long lastTime;

        public HitRate(Integer key, Integer hitCount, Long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        public int compareTo(HitRate o) {
            int hr = hitCount.compareTo(o.hitCount);
            return hr != 0 ? hr : lastTime.compareTo(o.lastTime);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

