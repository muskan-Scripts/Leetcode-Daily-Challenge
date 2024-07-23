class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Sort the array based on the frequency and then by value in decreasing order
        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqCompare = freqMap.get(a).compareTo(freqMap.get(b));
                if (freqCompare == 0) {
                    return b.compareTo(a); // Sort by value in decreasing order if frequencies are equal
                }
                return freqCompare; // Sort by frequency
            }
        });
        
        // Convert Integer array back to int array
        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }
}
