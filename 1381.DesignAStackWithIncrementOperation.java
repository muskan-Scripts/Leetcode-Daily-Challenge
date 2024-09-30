class CustomStack {
    int[] arr;
    int ptr=-1;
    public CustomStack(int maxSize) {
        this.arr=new int[maxSize];
    }
    
    public void push(int x) {
        if((this.ptr+1)==this.arr.length)return;
        this.arr[this.ptr+1]=x;
        this.ptr++;
    }
    
    public int pop() {
        if(ptr==-1)return -1;

        return this.arr[this.ptr--];
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<=Math.min(this.ptr, k-1); i++){
            this.arr[i]+=val;
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
