package goal.algorithms.bit.manipulation;

public class CheckBitSetForPosition {

	public static void main(String[] args) {

		int n = 1365, pos = 9;   // pos is the bit position from LSB. That is, if n=10101, pos=2, then it is 0 (2nd LSB)
		int k = 1;
		
		k = k << pos-1;
		
		if((n & k) > 0) {
			System.out.println(pos + " bit is set");
		} else {
			System.out.println(pos + " bit is NOT set");
		}
	}

}
