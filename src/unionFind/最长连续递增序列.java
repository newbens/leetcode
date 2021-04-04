package unionFind;

public class 最长连续递增序列 {
    public static void main(String[] args){
        int[] nums = {1,3,5,4,7};
        System.out.println(new 最长连续递增序列().findLengthOfLCIS(nums));

    }
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int help = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                max = Math.max(max, ++help);
            } else help = 1;
        }
        return max;
    }
}
