public class Q84 {

    // a better solution:
    // O(n) - using stack

    // public int largestRectangleArea(int[] heights) {
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     stack.push(-1);
    //     int length = heights.length;
    //     int maxArea = 0;
    //     for (int i = 0; i < length; i++) {
    //         while ((stack.peek() != -1)
    //                 && (heights[stack.peek()] >= heights[i])) {
    //             int currentHeight = heights[stack.pop()];
    //             int currentWidth = i - stack.peek() - 1;
    //             maxArea = Math.max(maxArea, currentHeight * currentWidth);
    //         }
    //         stack.push(i);
    //     }
    //     while (stack.peek() != -1) {
    //         int currentHeight = heights[stack.pop()];
    //         int currentWidth = length - stack.peek() - 1;
    //         maxArea = Math.max(maxArea, currentHeight * currentWidth);
    //     }
    //     return maxArea;
    // }

    // normal way - divider
    // O(n log n)

    public int largestRectangleArea(int[] heights) {
        return calculateLargest(heights, 0, heights.length-1);
        
    }

    private int calculateLargest(int[] heights, int start, int end){
        if (start > end){
            return 0;
        }
        int minindex = start;
        for (int i=start; i<=end; i++){
            if (heights[minindex]>heights[i]){
                minindex = i;
            }
        }
        return Math.max(heights[minindex]*(end-start+1), 
            Math.max(calculateLargest(heights, start, minindex-1), calculateLargest(heights, minindex+1, end)));
    }
}
