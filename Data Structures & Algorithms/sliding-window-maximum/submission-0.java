class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            // Remove smaller values from the back
            while (!deque.isEmpty() && nums[r] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            // Add current index
            deque.addLast(r);
            // Remove indices outside the window
            if (deque.peekFirst() < l) {
                deque.pollFirst();
            }
            // Window is size k
            if (r + 1 >= k) {
                ans.add(nums[deque.peekFirst()]);
                l++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}