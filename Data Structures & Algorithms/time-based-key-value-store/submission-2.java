class TimeMap {

    class Pair {
        int time;
        String value;

        public Pair(int time, String value){
            this.time = time;
            this.value = value;
        }
    }

    HashMap<String, ArrayList<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        if(!(store.containsKey(key))){
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if(!(store.containsKey(key))){
            return "";
        }
        ArrayList<Pair> x = store.get(key);
        int l = 0;
        int r = x.size()-1;
        String ans = "";
        while(l <= r){
            int mid = (l+r)/2;
            if(x.get(mid).time <= timestamp){
                ans = x.get(mid).value;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }
}
