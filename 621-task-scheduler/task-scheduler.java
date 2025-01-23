class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        for(int i = 0; i<26; i++){
            if(freq[i]>0){
                 maxHeap.add(freq[i]);
            }
        }

        int time = 0;

        while(!maxHeap.isEmpty()) {
            int cycle = n+1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            while(cycle-- >0 && !maxHeap.isEmpty()){
                int currentFreq = maxHeap.poll();
                if(currentFreq>1){
                    store.add(currentFreq-1);
                }
                taskCount++;
            }
            store.forEach(maxHeap::add);
            time += (maxHeap.isEmpty())?taskCount:n+1;
        }
        return time;
    }
}