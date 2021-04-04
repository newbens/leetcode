package unionFind;

import java.util.Arrays;

public class 分发糖果 {
    public static void main(String[] args){
        int[] a = {1,2,2};
        int candy = candy(a);
        System.out.println(candy);
    }
//左右各遍历一次 使其满足条件 整体就满足条件。
    public static int candy(int[] ratings){
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < left.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int num = left[ratings.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i + 1] + 1;
            }
            num += Math.max(left[i], right[i]);
        }
        return num;
    }
}
