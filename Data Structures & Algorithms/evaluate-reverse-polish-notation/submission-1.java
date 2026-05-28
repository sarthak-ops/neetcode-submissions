class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> x = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                int one = x.pop();
                int two = x.pop();
                int res = one+two;
                x.push(res);
            }
            else if(s.equals("-")){
                int one = x.pop();
                int two = x.pop();
                int res = two-one;
                x.push(res);
            }
            else if(s.equals("/")){
                int one = x.pop();
                int two = x.pop();
                int res = two/one;
                x.push(res);
            }
            else if(s.equals("*")){
                int one = x.pop();
                int two = x.pop();
                int res = one*two;
                x.push(res);
            }
            else{
                int cur = Integer.parseInt(s);
                x.push(cur);
            }
        }
        return x.pop();
    }
}
