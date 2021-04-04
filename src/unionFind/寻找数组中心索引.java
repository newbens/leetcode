package unionFind;

public class 寻找数组中心索引 {
    public static void main(String[] args){
        int[] nums = {-1,-1,0,0,-1,-1};
        System.out.println(new 寻找数组中心索引().pivotIndex(nums));
    }
    public int pivotIndex(int[] nums) {
        int count = 0;
        int n = nums.length;
        if(n==0) return -1;
        for (int i = 0; i < n; i++) {
            count += nums[i];
        }
        int l = nums[0];
        for (int i = 1; i < n ; i++) {
            if (l * 2 + nums[i] == count) {
                return i;
            } else l += nums[i];
        }
        return -1;
    }
}
