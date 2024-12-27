class Solution {
    HashMap<Integer,List<Integer>> hm;
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        hm = new HashMap<>();
        for(int[] pre : prerequisites) {
            List<Integer> list = hm.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            hm.put(pre[0], list);
        }
        for(int i =0; i<numCourses; i++){
            if(!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int course){
        if(visited.contains(course)){
            return false;
        }
        if(!hm.containsKey(course)){
            return true;
        }
        visited.add(course);
        for(int i : hm.get(course)){
            if(!dfs(i)) return false;
        }
        visited.remove(course);
        hm.remove(course);
        return true;
    }
}