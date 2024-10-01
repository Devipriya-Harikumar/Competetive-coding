class CustomStack {

    private Stack<Integer> stack;
    private int maxSize;
    private List<Integer> list;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        this.maxSize = maxSize; 
        this.list = new ArrayList<>();
    }
    
    public void push(int x) {
        if(stack.size()<maxSize){
            stack.push(x);
            list.add(0);
        }
    }
    
    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        } 
        if (list.size() > 1) list.set(list.size() - 2, list.get(list.size() - 2) + list.get(list.size() - 1));
        return stack.pop() + list.remove(list.size() - 1);
    }
    
    public void increment(int k, int val) {
        if (!stack.isEmpty()) {
            int index = Math.min(k, list.size()) - 1;
            list.set(index, list.get(index) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */