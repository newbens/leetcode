package unionFind;

import java.util.Arrays;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    public static void main(String[] args){
        int[] nums = {7,2,4};
        int k = 2;
        int[] ints = new 滑动窗口最大值().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
       if(nums.length == 1) return nums;
        LinkedList<Integer> queue = new LinkedList();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //单调递减 双向队列
            if (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i); //存入下标
            //判断是否符合规则
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            //达到窗口大小 开始给数组赋值
            if (i+1 >= k) {
                res[i + 1 - k] = nums[queue.peek()];
            }
        }
        return res;
    }
}
