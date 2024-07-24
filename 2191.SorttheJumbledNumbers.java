
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Create an array to store the mapped values
        int[] mappedValues = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            mappedValues[i] = getMappedValue(mapping, nums[i]);
        }

        // Create an array of indices
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the mapped values
        Arrays.sort(indices, (i, j) -> Integer.compare(mappedValues[i], mappedValues[j]));

        // Create the result array using the sorted indices
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[indices[i]];
        }

        return result;
    }

    // Helper method to get the mapped value of a number based on the mapping array
    private int getMappedValue(int[] mapping, int num) {
        String numStr = String.valueOf(num);
        StringBuilder mappedStr = new StringBuilder();
        
        for (char c : numStr.toCharArray()) {
            mappedStr.append(mapping[c - '0']);
        }
        
        return Integer.parseInt(mappedStr.toString());
    }}
