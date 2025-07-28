public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        // Calculate total gas and total cost for the entire circui
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // If total gas is less than total cost, it's impossible to complete the circuit
        if (totalGas < totalCost)
            return -1;

        int currGas = 0; // Current tank gas while traversing
        int j = 0; // Candidate starting station

        // Try to find the starting station
        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i]; // Update current gas after visiting station i

            // If at any point gas in tank is negative, we can't start from 'j'
            if (currGas < 0) {
                currGas = 0; // Reset current gas
                j = i + 1; // Try next station as starting point
            }
        }
        // Return the valid starting index
        return j;
    }

    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
