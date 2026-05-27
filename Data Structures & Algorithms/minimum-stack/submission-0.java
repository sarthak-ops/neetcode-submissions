class MinStack {

    ArrayList<Integer> x;

    public MinStack() {
        x = new ArrayList<>();
    }
    
    public void push(int val) {
        x.add(val);
    }
    
    public void pop() {
        x.remove(x.size()-1);
    }
    
    public int top() {
        return x.get(x.size()-1);
    }
    
    public int getMin() {
        int min = x.get(0);
        for(int m : x){
            min = Math.min(min, m);
        }
        return min;
    }
}
