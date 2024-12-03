class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;
        while(i<s.length()){
            while(i<s.length() && j<spaces.length && i!=spaces[j]){
                sb.append(s.charAt(i++));
            }
            if(i==spaces[j]){
                sb.append(' ');
                j++;
            }
            while(j>=spaces.length && i<s.length()){
                sb.append(s.charAt(i++));
            }
        }
        String res=  sb.toString();
        return res;
    }
}
