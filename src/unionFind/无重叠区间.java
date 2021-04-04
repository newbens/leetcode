package unionFind;

import java.util.Arrays;
import java.util.Comparator;

public class 无重叠区间 {
    public static void main(String[] args){
        int[][] inter = {{1, 100}, {11,22}, {1,11}, {2,12}};
        System.out.println(new 无重叠区间().eraseOverlapIntervals(inter));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < pre) res++;
            else pre = intervals[i][1];
        }
        return res;
    }
}
