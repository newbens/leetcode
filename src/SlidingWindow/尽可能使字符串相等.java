package SlidingWindow;

public class 尽可能使字符串相等 {
    public static void main(String[] args){
        String s = "abcd";
        String t = "bcdf";
        System.out.println(new 尽可能使字符串相等().equalSubstring(s, t, 3));
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp += cost[i]; //窗口扩大
            if (temp > maxCost) { //预算不够 窗口右移
                temp -= cost[i - res];
            }else {
                res++; //代表窗口目前大小
            }
        }
        return res;
    }
}
