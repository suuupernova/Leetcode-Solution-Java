/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        //统计链表长度
        int length=0;
        ListNode node=head;
        while(node!=null){
            length+=1;
            node=node.next;
        }
        ListNode dummy=new ListNode(-1,head);

        for(int subLength=1;subLength<length;subLength<<=1){
            ListNode prev=dummy;
            ListNode cur=dummy.next;
            while(cur!=null){
                ListNode left=cur;
                ListNode right=cut(left,subLength);
                cur=cut(right,subLength);
                prev.next=merge(left,right);
                while(prev.next!=null){
                    prev=prev.next;
                }
            }
        }
        return dummy.next;

    }
    private ListNode cut(ListNode from,int subLength){
        subLength--;
        while(from!=null&&subLength>0){
            subLength--;
            from=from.next;
        }
        if(from==null){
            return null;
        }else{
            ListNode next=from.next;
            from.next=null;
            return next;
        }
    }
    //合并有序链表
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return dummy.next;
    }
}
