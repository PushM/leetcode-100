import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /*
    使用双向链表+哈希表 get、put都是 1，空间是capacity
    为什么使用双向链表呢？
     */
    //双向链表节点类
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key, int value){this.key = key; this.value = value;};
    }
    //新建哈希表，哈希表存储键是key，值是节点
    Map<Integer, DLinkedNode> hashMap = new HashMap<Integer, DLinkedNode>();
    //属性值定义size、capacity
    int size;
    int capacity;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    /*
    对于 get 操作，首先判断 key 是否存在：
        如果 key 不存在，则返回 −1；
        如果 key 存在，则 key 对应的节点是最近被使用的节点。通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，最后返回该节点的值。
     */
    public int get(int key) {
        if (!hashMap.containsKey(key)){
            return -1;
        }else {
            DLinkedNode node = hashMap.get(key);
            moveToHead(node);
            return node.value;
        }
    }
    /*
    对于 put 操作，首先判断 key 是否存在：
        如果 key 不存在，使用 key 和 value 创建一个新的节点，在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。
            然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，并删除哈希表中对应的项；
        如果 key 存在，则与 get 操作类似，先通过哈希表定位，再将对应的节点的值更新为 value，并将该节点移到双向链表的头部。
     */
    public void put(int key, int value) {
        if (!hashMap.containsKey(key)){
            //新建节点、插入链表头部、插入哈希表
            DLinkedNode node = new DLinkedNode(key, value);
            addToHead(node);
            hashMap.put(key, node);
            ++size;
            //删除尾部元素，删除哈希表
            //还得判断LRUCache当前size是否超过capacity
            if(size > capacity) {
                DLinkedNode deleteNode = removeTail();
                hashMap.remove(deleteNode.key);
                --size;
            }
        }else {
            DLinkedNode node = hashMap.get(key);
            moveToHead(node);
            node.value = value;
        }
    }

    public void addToHead(DLinkedNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(DLinkedNode node){
        //先删除node
        removeNode(node);
        //再把node放到首位
        addToHead(node);
    }

    public DLinkedNode removeTail(){
        DLinkedNode deleteNode = tail.prev;
        removeNode(deleteNode);
        return deleteNode;
    }
}
