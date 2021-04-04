package unionFind;

import java.util.Arrays;

public class 旋转数组 {
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        new 旋转数组().rotate(nums,k);
    }
    //[1,2,3,4,5] k = 2  [4,5,1,2,3]
    public void rotate(int[] nums, int k) {
        reverse(nums, 0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public int[] reverse(int[] arr,int start,int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return arr;
    }
}
