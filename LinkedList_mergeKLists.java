import java.util.PriorityQueue;

public class LinkedList_mergeKLists {
    /*
    合并k个有序链表

    （1）合并2个有序链表 时间 n 空间 1；k个的话一个个合并 n，2n，3n，...，kn  时间 k^2 *n  空间 1

     （2）分治合并：两个两个合并  时间 k*n*logk 空间 logk

     （3）优先队列：维护一个k大小的优先队列，存储着k个链表最前面的元素，每次在这些元素里面选取 val属性最小的元素合并到答案中
            时间 k*n*logk 因为优先队列的插入删除是logk   空间 k
     */


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0) ;
        ListNode tail = head;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null? l2:l1;
        return head.next;
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (l + r)/2;

        return mergeTwoLists(merge(lists,l,mid), merge(lists,mid+1,r));
    }


    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists,0,lists.length-1);
    }

    /**
     * 基于优先队列实现
     */

    //初始化优先队列，包含k个元素
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode node : lists) {//这是 Java 中的一种增强型 for 循环（也称为 for-each 循环），用于遍历一个数组或集合中的元素。
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }

        //不停的从优先队列中取出队首元素，插入到合并的链表后面，并用队首元素存储节点的next节点更新优先队列
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!queue.isEmpty()){//判断非空 isEmpty()
            ListNode queueNode = queue.poll().node;
            tail.next = queueNode;
            tail = tail.next;

            if (queueNode.next != null){
                queue.offer(new Status(queueNode.next.val, queueNode.next));
            }
        }

        return  head.next;
    }
    //首先定义一个队列中的元素，包含节点val和节点，实现 Comparable 接口，重写compareTo 方法
    class Status implements Comparable<Status>{
        int val;
        ListNode node;
        Status(int val, ListNode node){
            this.val = val;
            this.node = node;
        }
        public int compareTo(Status status2){
            return this.val - status2.val;
        }
    }
}
