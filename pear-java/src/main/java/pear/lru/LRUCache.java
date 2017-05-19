package pear.lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/#/description
 * 
 * @author pei.lv
 */
public class LRUCache {

    public List<Integer> keyList;

    public Map<Integer, Integer> cache;

    public int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyList = new ArrayList<Integer>(capacity);
        cache = new HashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        Integer val = cache.get(key);
        if (val != null) {
            // 将val放到头部
            addHeadToList(key);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        addHeadToList(key);
        cache.put(key, value);
    }

    private void addHeadToList(int key) {
        if (keyList.contains(key)) {
            keyList.remove((Object) key);
            keyList.add(key);
        } else {
            keyList.add(key);
        }
        if (keyList.size() > capacity) {
            int k = keyList.get(0);
            keyList.remove(0);
            cache.remove(k);
        }
    }

}
