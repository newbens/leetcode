package March;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class 基本计算器 {
    public static void main(String[] args){
        String s = "2147483647";
        int calculate = new 基本计算器().calculate(s);
        System.out.println(calculate);
    }
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        int flag = 1;
        int len = cs.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(cs[i])) {  //如果是数字
                int cur = cs[i] - '0';
                while (i + 1 < len && Character.isDigit(cs[i+1])) {
                    cur = cur * 10 + cs[++i] - '0';
                }
                res = res + flag * cur;
            } else if (cs[i] == '+') {
                flag = 1;
            } else if (cs[i] == '-') {
                flag = -1;
            } else if (cs[i] == '(') { //stack存入(之前的计算式总值。
                stack.push(res);
                res = 0; //初始化res
                stack.push(flag);
                flag = 1;//初始化flag
            } else if (cs[i] == ')') {
                //代表这个括号内结束，此时栈顶是符号位，栈顶第二个是这对括号外的计算式总值。
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}
