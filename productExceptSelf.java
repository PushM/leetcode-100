public class productExceptSelf {
    /*
    两种方法：
    (1)先构建L[i]，R[i]表示i左边所有元素乘积，i右边所有元素成绩。然后再遍历一下i就可以了。
    空间、时间复杂度都是O(N)
    (2)ans[]作为L[]。R[]用一个int变量持续更新。ans不占空间
    空间O(1),时间O(n)
     */
    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] ans = new int[length];

        L[0] = 1;//**注意边界是0
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {//先判断i>=0，再执行循环体，最后再执行i--
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int R = 1;

        ans[0] = 1;
        for (int i = 1; i < length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}
