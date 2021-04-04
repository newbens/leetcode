package SlidingWindow;

public class 替换后的最长重复字符串 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(new 替换后的最长重复字符串().characterReplacement(s, k));
    }

    private int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        int left = 0;
        int preMax = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'A';
            map[index] += 1;
            preMax = Math.max(preMax, map[index]);//存放滑动窗口内 所有字母个数。
            if(i- left + 1 > preMax+k){//如果前面总长度大于最多字母个数+k说明滑动窗口要右移
                map[chars[left] - 'A'] -= 1;  //右移后 之前右边第一个字母就会不在滑动窗口内 所以减一。
                left++;
            }
        }
        return chars.length - left;
    }
}
