package interview.cake.array;

public class FirstComeFirstServe {
    public static boolean isFirstComeFirstServed(int[] takeOutOrders,
                                                 int[] dineInOrders,
                                                 int[] servedOrders) {
        int currentTakeOutOrder = 0;
        int currentDineInOrder = 0;

        for (int currentOrderServed : servedOrders) {
            // guard against index out of bounds issues
            boolean isTakeOutOrdersComplete =
                    takeOutOrders.length == currentTakeOutOrder;
            boolean isDineInOrderComplete =
                    dineInOrders.length == currentDineInOrder;

            if (!isTakeOutOrdersComplete &&
                    currentOrderServed == takeOutOrders[currentTakeOutOrder]) {
                currentTakeOutOrder++;
            } else if (!isDineInOrderComplete &&
                    currentOrderServed == dineInOrders[currentDineInOrder]) {
                currentDineInOrder++;
            } else {
                return false;
            }
        }

        return currentDineInOrder == dineInOrders.length
                && currentTakeOutOrder == takeOutOrders.length;
    }

    public static void main(String[] args) {
        int[] takeOutOrders = new int[]{1, 4, 5};
        int[] dineInOrders = new int[]{2, 3, 6};
        int[] servedOrders = new int[]{1, 2, 3, 4, 5, 6};

        int[] takeOutOrders2 = new int[]{1, 3, 5};
        int[] dineInOrders2 = new int[]{2, 4, 6};
        int[] servedOrders2 = new int[]{1, 2, 4, 6, 5, 3};

        System.out.println(isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders)); // true
        System.out.println(isFirstComeFirstServed(takeOutOrders2, dineInOrders2, servedOrders2)); // false
    }
}
