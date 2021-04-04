package SlidingWindow;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class 绝对差不超过限制的最长连续子数组 {
    public static void main(String[] args) {
        int[] n = {8, 2, 4, 7};
        int l = 4;
        System.out.println(new 绝对差不超过限制的最长连续子数组().longestSubarray(n, l));
    }

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int res = 0, le = 0, ri = 0;
        Queue<Integer> min = new PriorityQueue<>(Comparator.naturalOrder());//找最小值
        Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());//找最大值
        while (le < n && ri < n) {
            max.add(nums[ri]);
            min.add(nums[ri]);
            if (getDiff(min.peek(),max.peek()) <= limit) {
                res = Math.max(res, ri - le + 1);
                ri++;//扩大
                continue;
            }
            max.remove(nums[le]);
            min.remove(nums[le]);
            le++;  //滑动窗口移动
            ri++;
        }
        return res;
    }

    public int getDiff(int a, int b) {
        return Math.abs(a - b);
    }
}
