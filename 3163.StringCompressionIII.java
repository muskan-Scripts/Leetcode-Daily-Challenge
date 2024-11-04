class Solution {
    public String compressedString(String word) {
        StringBuilder sb= new StringBuilder();
        int i=0;
        while(i<word.length()){
            char curr= word.charAt(i++);
            int cnt=1;
            while(i<word.length() && word.charAt(i)==curr && cnt<9){
                cnt++;
                i++;
            }

            sb.append((char)(cnt+'0'));
            sb.append(curr);
        }

        return sb.toString();
    }
}
