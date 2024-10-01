package facebook;

public class FriendsOfAppropriateAges {

    public static void main(String[] args) {
        int[] ages = {20, 30, 100, 110, 120};
        int result = countFriendRequests(ages);
        System.out.println(result);
    }

    private static int countFriendRequests(int[] ages) {
        int[] map = new int[121];
        int result = 0;

        // Count how many people there are for each age
        for (int i : ages) map[i]++;

        for (int a = 1; a <= 120; a++) {
            // Iterate over the allowed range for B's age
            for (int b = (int)(0.5 * a + 7 + 1); b <= a; b++) {
                result += map[a] * map[b];
                // A will not friend request him/herself
                if (a == b) result -= map[a];
            }
        }

        return result;
    }
}
