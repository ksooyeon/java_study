
class MinStack {
    List<Integer> stack;
    
  /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        stack.add(x);
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        int min = stack.get(0);
        for(int i=1;i<stack.size();i++){
            if(stack.get(i) < min)
                min = stack.get(i);
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
