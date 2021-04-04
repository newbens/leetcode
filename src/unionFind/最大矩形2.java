package unionFind;

public class 最大矩形2 {
    public static void main(String[] args){
        int[] heights = {2, 1, 5, 6, 2, 3};
        int i = new 最大矩形2().largestRectangleArea(heights);
        System.out.println(i);
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            for (int j = i; j < heights.length; j++) {
                h = Math.min(h, heights[j]);
                res = Math.max(res, h * (j - i + 1));
            }
        }
        return res;
    }
}
