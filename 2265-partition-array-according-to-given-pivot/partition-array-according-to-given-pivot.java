class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<Integer>();
        List<Integer> more = new ArrayList<Integer>();
        List<Integer> equal = new ArrayList<Integer>();

        for(int i : nums){
            if(i<pivot){
                less.add(i);
            } else if(i>pivot){
                more.add(i);
            } else {
                equal.add(i);
            }
        }
        int[] result = new int[nums.length];
        int i = 0;
        for(i = 0; i< less.size(); i++){
            result[i] = less.get(i);
        }
        for(int j = 0; j< equal.size(); j++, i++){
            result[i] = equal.get(j);
        }
        for(int j = 0; j< more.size(); j++,i++){
            result[i] = more.get(j);

        }
        return result;
    }
}