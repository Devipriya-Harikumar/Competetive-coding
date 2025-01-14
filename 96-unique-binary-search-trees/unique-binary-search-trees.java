class Solution {
    public int numTrees(int n) {
        int[] num = new int[n +1];
        Arrays.fill(num, 1);

        for(int node =2; node <= n; node++){
            int total = 0;
            for(int root = 1; root<=node; root++){
                total += num[root-1]*num[node-root];
            }
            num[node]=total;
        }
        return num[n];
    }
}