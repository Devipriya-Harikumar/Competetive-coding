class Solution {
    public int[][] kClosest(int[][] points, int k) {
         PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            maxHeap.offer(point);

            // If the heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare the result array to store the k closest points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result; 
    }
}