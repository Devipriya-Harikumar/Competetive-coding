class Solution {
    int[] par;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        par = new int[len + 1];
        rank = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            par[i] = i;
            // rank[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(edges[i][0] + " ");
            System.out.print(edges[i][1] + " ");
            boolean check = union(edges[i][0], edges[i][1]);
            System.out.print( check + "\n");
            if(!check)
                return edges[i];
        }
        return null;
    }

    private int find(int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2)
            return false;

        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        } 
        return true;
    }

}