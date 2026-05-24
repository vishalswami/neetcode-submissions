class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGasAvailable = 0;
        int totalGasNeeded = 0;
        for(int i=0; i<gas.length; i++) {
            totalGasAvailable += gas[i];
            totalGasNeeded += cost[i];
        }

        if(totalGasAvailable < totalGasNeeded) {
            return -1;
        }

        int gasInCar = 0;
        for(int i=0; i<gas.length; i++) {
            if(cost[i] <= gas[i]) {
                gasInCar += gas[i];
                gasInCar -= cost[i];
                int j=nextStopIndex(gas.length, i);
                if(i==j) {
                    return i;
                }
                while(true) {
                    if (gasInCar+gas[j] >= cost[j]) {
                        gasInCar += gas[j];
                        gasInCar -= cost[j];
                        j=nextStopIndex(gas.length, j);
                        if(j==i) {
                            return i;
                        }
                    } else {
                        gasInCar = 0;
                        break;
                    }
                }
            }
        }
        return -1;
    }

    private int nextStopIndex(int totalStops, int currentStop) {
        return currentStop+1 <= totalStops-1? currentStop+1: 0;  
    }
}
