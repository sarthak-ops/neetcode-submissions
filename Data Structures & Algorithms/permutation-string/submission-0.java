class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> x = new HashMap<>();
        HashMap<Character, Integer> y = new HashMap<>();
        if(s1.length() > s2.length()){
            return false;
        }
        for(int i = 0; i < s1.length(); i++){
            x.put(s1.charAt(i), x.getOrDefault(s1.charAt(i), 0) + 1);
            y.put(s2.charAt(i), y.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int m = 0;
        for(int i = s1.length(); i < s2.length(); i++){
            char prev = s2.charAt(m);
            char curr = s2.charAt(i);
            if(x.equals(y)){
                return true;
            }
            y.put(prev, y.get(prev)-1);
            if(y.get(prev) == 0){
                y.remove(prev);
            }
            if(y.containsKey(curr)){
                y.put(curr, y.getOrDefault(curr, 0) + 1);
            }
            else{
                y.put(curr, 1);
            }
            m++;
        }
        return x.equals(y);
    }
}
