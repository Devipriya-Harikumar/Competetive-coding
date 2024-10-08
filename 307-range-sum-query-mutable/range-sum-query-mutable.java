class NumArray {
int bit[];
int nums[];
int n;
    public NumArray(int[] nums) {
        this.nums=nums;
        this.n=nums.length;
        bit=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            updateBIT(i,nums[i]);
        }
        
    }
    public void updateBIT(int i,int val){
         int j=i+1;
            while(j<=n){
            bit[j]+=val;
            j+=(j&-j);
            }
    }
    public void update(int index, int val) {
        int d=val-nums[index];
        nums[index]=val;
        updateBIT(index,d);
    }
    public int getSum(int l){
        l+=1;
        int sum=0;
        while(l>0){
        sum+=bit[l];
        l-=(l&-l);
        }
        return sum;
    }
    public int sumRange(int left, int right) {
        return (getSum(right)-getSum(left-1));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */