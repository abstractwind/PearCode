package pear;

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

    public static void main(String[] args) {                                                                                                                                                                               
        LRUCache cache = new LRUCache(2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}

//public class LRUCache {
//
//    public List<Integer> keyList;
//
//    public Map<Integer, Integer> cache;
//
//    public int capacity;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        keyList = new ArrayList<Integer>(capacity);
//        cache = new HashMap<Integer, Integer>(capacity);
//    }
//
//    public int get(int key) {
//        Integer val = cache.get(key);
//        if (val != null) {
//            // 将val放到头部
//            addHeadToList(key);
//            return val;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        addHeadToList(key);
//        cache.put(key, value);
//    }
//
//    private void addHeadToList(int key) {
//        if (keyList.contains(key)) {
//            keyList.remove((Object)key);
//            keyList.add(key);
//        } else {
//            keyList.add(key);
//        }
//        if (keyList.size() > capacity) {
//            int k = keyList.get(0);
//            keyList.remove(0);
//            cache.remove(k);
//        }
//    }
//
//}
