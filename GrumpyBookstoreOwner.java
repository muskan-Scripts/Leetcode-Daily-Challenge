class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int st = 0;
        int end = minutes - 1;

        int sum = 0;
        for (int i = 0; i < minutes; i++) {
            sum = sum + customers[i]*grumpy[i];
        }
        int max = sum;
        int arr[] = { 0, minutes - 1 };
        while (end+1 < grumpy.length) {
            sum = sum - customers[st]*grumpy[st];
            st++;
            ++end;
            sum = sum + customers[end]*grumpy[end];
            if (sum > max) {
                arr[0] = st;
                arr[1] = end;
                max = sum;
            }
        }

        for(int i=arr[0]; i<=arr[1]; i++){
            grumpy[i]=0;
        }

        int finalans=0;
        for(int i=0; i<grumpy.length; i++){
            if(grumpy[i]==0){
                finalans=finalans+ customers[i];
            }
        }
        return finalans;

    }
}
