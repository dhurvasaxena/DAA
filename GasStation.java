public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        return (totalGas >= totalCost) ? startIndex : -1;
    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }
}