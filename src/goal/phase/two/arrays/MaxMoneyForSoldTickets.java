package goal.phase.two.arrays;

public class MaxMoneyForSoldTickets {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int soldTickets = 25;
        int initialTickets[] = { 1, 5, 3, 14, 7 };

        int maxMoney = getMaxMoneyForSoldTickets(soldTickets, initialTickets);
        System.out.println("Max money for sold tickets: " + maxMoney);
    }

    private static void test2() {
        int soldTickets = 4;
        int initialTickets[] = { 1, 5 };

        int maxMoney = getMaxMoneyForSoldTickets(soldTickets, initialTickets);
        System.out.println("Max money for sold tickets: " + maxMoney);
    }

    private static int getMaxMoneyForSoldTickets(int soldTickets, int[] initialTickets) {

        int money = 0;

        for (int i = soldTickets; i > 0; i--) {
            int maxTicketsStallIndex = getMaxTicketsStallIndex(initialTickets);
            money += initialTickets[maxTicketsStallIndex];
            initialTickets[maxTicketsStallIndex]--;
        }

        return money;
    }

    private static int getMaxTicketsStallIndex(int[] initialTickets) {

        int maxTickets = 0;
        int maxIndex = -1;

        for (int i = 0; i < initialTickets.length; i++) {
            if (initialTickets[i] > maxTickets) {
                maxTickets = initialTickets[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}
