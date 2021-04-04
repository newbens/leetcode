package SlidingWindow;

import java.awt.geom.RectangularShape;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组的度 {
    public static void main(String[] args){
        int[] nums = {1};
        System.out.println(new 数组的度().findShortestSubArray(nums));
    }
    public int findShortestSubArray(int[] nums) {
        int l = 0, r = 0, len = nums.length, res = len + 1;
        Map<Integer, Integer> map = new HashMap<>();
        int maxDegree = getDeg(nums);
        while (r < len) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            r++;
            while (map.get(nums[r - 1]) == maxDegree) {
                map.put(nums[l], map.get(nums[l]) - 1);
                res = Math.min(res, r - l);
                l++;
            }
        }
        return res;
    }

    public int getDeg(int[] a) {
        int deg = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }else {
                Integer cnt = map.get(i)+1;
                map.put(i,cnt);
                deg = Math.max(deg, cnt);
            }
        }
        return deg;
    }
}
