class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int left = Math.max(ax1, bx1), right  = Math.max(Math.min(ax2, bx2), left);
        int bottom = Math.max(ay1, by1), top = Math.max(Math.min(ay2, by2), bottom);
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1)*(by2-by1) - (right-left)*(top - bottom);
    }
}