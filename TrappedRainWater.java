public class TrappedRainWater {

    /*
     * Assignment 3:
     * Trapped Rainwater Problem (Elevation Map)
     *
     * Given an array representing elevation heights,
     * compute how much water can be trapped after raining.
     *
     * Example:
     * {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5}
     * Expected Output: 26 units
     */

    /*
     * This method calculates the total trapped water.
     * Using the two-pointer technique.
     */

    static int trap(int[] height) {

        // If array is empty, no water can be trapped
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;                          // start pointer
        int right = height.length - 1;         // end pointer

        int leftMax = 0;                       // highest wall from left side
        int rightMax = 0;                      // highest wall from right side

        int totalWater = 0;                    // total trapped water

        /*
         * Move both pointers toward the center.
         * At each step, calculate how much water
         * can be stored at that position.
         */

        while (left < right) {

            // Compare heights at both ends
            if (height[left] <= height[right]) {

                // Update leftMax if current height is higher
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Water trapped = leftMax - current height
                    totalWater += (leftMax - height[left]);
                }

                left++;

            } else {

                // Update rightMax if current height is higher
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Water trapped = rightMax - current height
                    totalWater += (rightMax - height[right]);
                }

                right--;
            }
        }

        return totalWater;
    }

    /*
     * Main method to test the elevation map
     * given in the assignment.
     */

    public static void main(String[] args) {

        int[] elevationMap = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};

        int result = trap(elevationMap);

        System.out.println("Trapped water: " + result + " units");
    }
}
