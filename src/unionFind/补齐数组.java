package unionFind;

public class 补齐数组 {
    static int[] nums;
    public static void main(String[] args){
        nums = new int[]{1,5,10};
        System.out.println(new 补齐数组().minPatches(nums, 20));
    }
    public int minPatches(int[] nums, int n) {
        int patch = 0; //需要插入的个数
        long x = 1;    //标志数
        int len = nums.length,index = 0;
        while (x <= n) {
            if (index < len && nums[index]<= x) {
                x += nums[index];
                index++;
            }else {
                //[1,2]区间 可以渠道数3(2*2-1) ,[1,x]可以取到1~2x-1;
                x *= 2;
                patch++;
            }
        }
        return patch;
    }
}
