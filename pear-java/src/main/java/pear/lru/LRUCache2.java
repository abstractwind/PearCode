package pear.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author pei.lv
 */
public class LRUCache2 {
    
    public int capacity;
    class Node {
        String name;
        int val;
        int key;
        Node pre;
        Node next;
        
        public Node(int key, int val,String name) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node [name=" + name + "]";
        }

        
    }
    
    private Node head = new Node(-1, -1,"head");
    private Node tail = new Node(-99, -99,"tail");
    private Map<Integer, Node> cache;
    
    
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>(capacity);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        remove(node);
        appendHead(node);
        return node.val;
    }

    /**
     * @param node
     */
    private void appendHead(Node node) {
        node.next = head.next;
        node.pre = head.next.pre;
        
        head.next.pre = node;
        head.next = node;
        cache.put(node.key, node);
    }

    /**
     * 删除当前node，前后指针指向前后node，如果node为头尾，则改变头尾节点的对应指针
     */
    private void remove(Node node) {
        cache.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = node.pre = null;
    }

    public void put(int key, int value) {
        int val = get(key);
        Node node = null;
        if(val == -1){
            node = new Node(key,value,String.valueOf(key));
            // 移动到head
            appendHead(node);
            
            // 判断cache大小
            if(cache.size() > capacity){
                // 删除队尾元素
                remove(tail.pre);
            }
        }else{
            if(val != value) {
                Node nodeT = cache.get(key);
                nodeT.val = value;
            }
        }
    }
}
