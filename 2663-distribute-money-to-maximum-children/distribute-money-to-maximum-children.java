class Solution {
    public int distMoney(int money, int children) {

        if (money < children) {
            return -1;
        }

        int moneyPostDist = money - children;
        int maxChildrenToGet8 = Math.min(children, moneyPostDist / 7);
        int moneyRemaing = moneyPostDist - maxChildrenToGet8*7;
        int childrenToGetMoney = children - maxChildrenToGet8;

        if (moneyRemaing == 3 && childrenToGetMoney == 1 || 
        (moneyRemaing !=0 &&childrenToGetMoney==0)) {
            return maxChildrenToGet8 - 1;
        } else {
            return maxChildrenToGet8;
        }
    }
}