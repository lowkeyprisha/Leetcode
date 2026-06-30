import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        PriorityQueue<Integer> smallNumbers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largeNumbers = new PriorityQueue<>();
        Map<Integer, Integer> leftoversToRemove = new HashMap<>();
        
        int smallCount = 0;
        int largeCount = 0;
        int resultIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            
            if (smallNumbers.isEmpty() || currentNumber <= smallNumbers.peek()) {
                smallNumbers.add(currentNumber);
                smallCount++;
            } else {
                largeNumbers.add(currentNumber);
                largeCount++;
            }
            
            if (i >= k) {
                int oldNumber = nums[i - k];
                leftoversToRemove.put(oldNumber, leftoversToRemove.getOrDefault(oldNumber, 0) + 1);
                
                if (oldNumber <= smallNumbers.peek()) {
                    smallCount--;
                } else {
                    largeCount--;
                }
            }
            
            if (smallCount > largeCount + 1) {
                largeNumbers.add(smallNumbers.poll());
                smallCount--;
                largeCount++;
            } else if (largeCount > smallCount) {
                smallNumbers.add(largeNumbers.poll());
                largeCount--;
                smallCount++;
            }
            
            while (!smallNumbers.isEmpty() && leftoversToRemove.getOrDefault(smallNumbers.peek(), 0) > 0) {
                int top = smallNumbers.poll();
                leftoversToRemove.put(top, leftoversToRemove.get(top) - 1);
            }
            while (!largeNumbers.isEmpty() && leftoversToRemove.getOrDefault(largeNumbers.peek(), 0) > 0) {
                int top = largeNumbers.poll();
                leftoversToRemove.put(top, leftoversToRemove.get(top) - 1);
            }
            
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    medians[resultIndex++] = (double) smallNumbers.peek();
                } else {
                    medians[resultIndex++] = ((double) smallNumbers.peek() + largeNumbers.peek()) * 0.5;
                }
            }
        }
        
        return medians;
    }
}