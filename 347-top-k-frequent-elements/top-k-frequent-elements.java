class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counterMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            counterMap.put(nums[i], counterMap.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] freq = new ArrayList[nums.length+1];
        for(int i = 0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry : counterMap.entrySet()){
            int frequency = entry.getValue();
            freq[frequency].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for(int i = freq.length-1;i>=0;i--) {
            for(int n : freq[i]){
                result[index++] = n;
                if(index==k) return result;
            }
        }
        return new int[0];
    }
}