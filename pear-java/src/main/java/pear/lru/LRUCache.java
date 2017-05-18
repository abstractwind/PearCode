package pear.lru;

import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/#/description
 * 
 * @author pei.lv
 */
public class LRUCache {

    protected int max_size;
//    protected static final int MAX_SIZE = 0;
    private Map<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        this.max_size = capacity;
        this.cache = new java.util.LinkedHashMap<Integer, Integer> (capacity, 0.75f, true) {

            // 定义put后的移除规则，大于容量就删除eldest
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > max_size;
            }
        };
        
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else
            return -1;
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
}

