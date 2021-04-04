package unionFind;

public class 三数最大乘积 {
    public static void main(String[] args){
        int[] a = {-100,-98,-1,2,3,4};
        System.out.println(new 三数最大乘积().maximumProduct(a));
    }
    public int maximumProduct(int[] nums) {

        int n = nums.length;
        for (int i = n/2-1; i >=0 ; i--) {
            buildHeap(nums,i,n-1);
        }
        int res = 1;
        for (int i = 0; i < 3; i++) {
            res *= nums[i];
            buildHeap(nums,i+1,n-1);
        }
        return res;

    }
    public void buildHeap(int[] a,int start,int end){
        int root = start;
        while (true) {
            int child = root * 2 + 1;
            if(child > end) break;
            if(child+1 <= end && a[child+1] > a[child]) child++;
            if (a[child] > a[root]) {
                int t = a[child];
                a[child] = a[root];
                a[root] = t;
            } else break;
        }
    }
}
