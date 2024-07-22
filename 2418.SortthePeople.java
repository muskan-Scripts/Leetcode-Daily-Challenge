class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] result= new String[names.length];
        Map<Integer, String> mp = new TreeMap();
        for(int i=0; i<names.length; i++){
            mp.put(heights[i], names[i]);
        }
        int i=0;
        for(String s: mp.values()){
            result[i++]=s;
        }
        i=0;
        int j=names.length-1;
        while(i<j){
            String k=result[i];
            result[i]=result[j];
            result[j]=k;
            i++;
            j--;
        }
        return result;
    }
}
