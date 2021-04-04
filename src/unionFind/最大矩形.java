package unionFind;

public class 最大矩形 {
    public static void main(String[] args){
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int i = new 最大矩形().maximalRectangle(matrix);
        System.out.println(i);
    }
    //利用84题的 最大柱状图思路解题，将矩阵一层一层遍历。
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)return 0;
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
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
