class Solution {
     public List<Integer> matchsticks;
    public int[] sums=new int[4];
    public int possibleSquareSide;

    public boolean makesquare(int[] matchsticks) {
          if (matchsticks == null || matchsticks.length == 0) {
            return false;
        }

        int L = matchsticks.length;
        int perimeter = 0;
        for(int i = 0; i < L; i++) {
            perimeter += matchsticks[i];
        }

        this.possibleSquareSide =  perimeter / 4;
        if (this.possibleSquareSide * 4 != perimeter) {
            return false;
        }

        this.matchsticks = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(this.matchsticks, Collections.reverseOrder());
        return this.dfs(0);
    }

     public boolean dfs(int index) {

        if (index == this.matchsticks.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        int element = this.matchsticks.get(index);

        for(int i = 0; i < 4; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                if (this.dfs(index + 1)) {
                    return true;
                }
                this.sums[i] -= element;
            }
        }

        return false;
    }
}