class MinStack {

    ArrayList<Integer> x;
    ArrayList<Integer> min;

    public MinStack() {
        x = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int val) {
        x.add(val);
        if(min.size() == 0 || min.get(min.size()-1) > val){
            min.add(val);
        }else{
            min.add(min.get(min.size()-1));
        }
    }
    
    public void pop() {
        x.remove(x.size()-1);
        min.remove(min.size()-1);
    }
    
    public int top() {
        return x.get(x.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
    }
}
