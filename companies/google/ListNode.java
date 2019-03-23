package google;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int val) {
		this.val = val;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(ListNode curr = this; curr != null; curr = curr.next) {
            sb.append(curr.val).append(curr.next != null ? "->" : "");
        }
        
        return sb.toString();
    }
}
