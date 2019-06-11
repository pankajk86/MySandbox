package facebook;

public class FirstBadVersion {

	public static void main(String[] args) {
		int n = 8; // 2126753390    1702766719
		boolean[] status = { true, true, true, true, true, true, true, true };
		VersionControl vc = new VersionControl(status);

		int result = firstBadVersion(n, vc);
		System.out.println(result);
	}

	private static int firstBadVersion(int n, VersionControl vc) {
		int start = 1, end = n;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (vc.isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}

class VersionControl {

	boolean[] status = null;

	VersionControl(boolean[] status) {
		this.status = status;
	}

	public boolean isBadVersion(int version) {
		return this.status[version - 1];
	}
}
