
/*
复制带随机指针的链表
本题要求我们对一个特殊的链表进行深拷贝。如果是普通链表，我们可以直接按照遍历的顺序创建链表节点。而本题中因为随机指针的存在，当我们拷贝节点时，「当前节点的随机指针指向的节点」可能还没创建
回溯+哈希表 时间 n 空间 n

迭代+节点拆分 时间 n 空间 1
 */


import java.util.HashMap;
import java.util.Map;

public class LinkedList_copyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        //哈希表
        Map<Node, Node> cacheNode = new HashMap<Node, Node>();
        //判断哈希表没有
        if (!cacheNode.containsKey(head)){
            //哈希表添加
            Node headNew = new Node(head.val);
            cacheNode.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }

    public Node copyRandomList2(Node head) {
        if (head ==null){
            return  null;
        }
        Node curr = head;
        //在后面创建复制的节点
        while (curr != null){
            Node currNew = new Node(curr.val);
            currNew.next = curr.next;
            curr.next = currNew;

            curr = curr.next.next;
        }
        //复制的节点更新random
        curr = head;
        while (curr != null){
            Node currNew = curr.next;
            currNew.random = curr.random == null? null:curr.random.next;
            curr = curr.next.next;
        }
        //拆分成两个链表
        curr = head;
        Node headNew = head.next;
        while (curr !=null){
            Node currNew = curr.next;
            curr.next = currNew.next;
//            currNew.next = curr.next.next;!!!!!!
            currNew.next = curr.next==null?null:curr.next.next;

            curr = curr.next;
        }
        return headNew;
    }

}
