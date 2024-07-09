class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0; // Track the current time
        double totalWaitingTime = 0; // Track the total waiting time
        
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookingTime = customer[1];
            
            // The chef starts cooking at the later of the current time or the customer's arrival time
            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }
            currentTime += cookingTime;
            
            // The waiting time for this customer is the time from their arrival to when their order is completed
            totalWaitingTime += (currentTime - arrivalTime);
        }
        
        // Calculate the average waiting time
        return totalWaitingTime / customers.length;
    }
}
