package SlidingWindow;

import java.util.Arrays;

public class 滑动窗口中位数 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        double[] doubles = new 滑动窗口中位数().medianSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(doubles));
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] res = new double[len - k + 1];
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        res[0] = getMid(temp);
        for (int i = 0; i < len - k ; i++) {
            int index = search(temp, nums[i]);
            temp[index] = nums[i + k];
            Arrays.sort(temp);
            res[i + 1] = getMid(temp);
        }
        return res;
    }

    public double getMid(int[] windows) {
        int len = windows.length;
        if (len % 2 == 0) {
            return windows[len / 2] /2.0  + windows[len / 2 - 1] / 2.0;
        } else {
            return windows[len / 2];
        }
    }

    public int search(int[] w, int tar) {
        int le = 0;
        int ri = w.length-1;    
        while (le <= ri) {
            int mid = le + (ri - le) / 2;
            if (w[mid] > tar) {
                ri = mid - 1;
            } else if (w[mid] < tar) {
                le = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
