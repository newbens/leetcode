package March;

import java.util.Stack;

public class 基本计算器2 {
    public static void main(String[] args) {
        String s = "1*2-3/4+5*6-7*8+9/10";
        System.out.println(new 基本计算器2().calculate(s));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {  //取数字 可能是多位数
                num = num * 10 + s.charAt(i) - '0';
            }
            //判断 i==n-1特判最后一个数字，因为遇到下一个运算符时，才会入栈之前的数，而最后一个数字后面没有运算符。
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);//下一轮数字前的运算符。
                num = 0;//初始化num。
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
