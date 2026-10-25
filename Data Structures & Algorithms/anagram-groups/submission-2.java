class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String f = new String(c);
            if(map.containsKey(f)){
                map.get(f).add(s);
            }
            else{
                map.put(f, new ArrayList<>());
                map.get(f).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}
