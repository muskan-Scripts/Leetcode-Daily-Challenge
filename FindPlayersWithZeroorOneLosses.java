class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> mp = new HashMap();
        for(int i=0; i<matches.length; i++){
            int f=matches[i][0];
            int n=matches[i][1];

            if(!mp.containsKey(f)){
                mp.put(f, 0);
            }
            if(!mp.containsKey(n)){
                mp.put(n, 0);
            }

            mp.put(n, mp.get(n)+1);
            
        }
        List<Integer> w= new ArrayList<>();
        List<Integer> ol= new ArrayList<>();
        List<List<Integer>> ans= new ArrayList<>();
        for(Map.Entry<Integer, Integer> it: mp.entrySet() ){
            int k=it.getKey();
            int v = it.getValue();
            if(v==0){
                w.add(k);
                
            }
            else if(v==1){
                ol.add(k);
            }
        }
        Collections.sort(w);
        Collections.sort(ol);
        ans.add(w);
        ans.add(ol);
        return ans;



    }
}
