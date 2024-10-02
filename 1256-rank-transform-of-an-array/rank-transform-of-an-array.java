class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int newArray[] = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(newArray);
        int i;
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;

        for (int index = 0; index < newArray.length; index++) {
            int element = newArray[index];
            if (ranks.get(element) == null) {
                ranks.put(element, rank);
                rank++;
            }
        }
        for (int index = 0; index < arr.length; index++) {
            int element = arr[index];
            arr[index] = ranks.get(arr[index]);
        }
        return arr;
    }
}