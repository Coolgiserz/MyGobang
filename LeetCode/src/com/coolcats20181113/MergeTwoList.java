package com.coolcats20181113;

public class MergeTwoList {

	public static void main(String[] args) {

		
	}
	
	/**
	 * 递归算法实现合并
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}
