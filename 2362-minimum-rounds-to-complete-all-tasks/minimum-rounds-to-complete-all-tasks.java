class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> taskFrequencyMap = new HashMap<>();
        for(int i= 0; i<tasks.length; i++) {
            taskFrequencyMap.put(tasks[i], 1+ taskFrequencyMap.getOrDefault(tasks[i],0));
        }
        System.out.println(taskFrequencyMap.toString());
        int task = 0;
         for (Integer frequency : taskFrequencyMap.values())  {
            if(frequency<2){
                return -1;
            } else if(frequency == 2) {
                task++;
            } else if(frequency%3 != 0){
                task = task + (frequency/3) + 1;
            } else {
                task = task + (frequency/3);
            }
         }
         return task;
    }
}