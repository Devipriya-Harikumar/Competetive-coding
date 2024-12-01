class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(pile, right);
        }
        int result = right;
        while(left<=right){
            int mid = (left + right)/2;
            if(getTime(piles, mid)<=h) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int getTime(int[] piles, int k){
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil((double)pile/k);
        }
        return hours;
    }
}