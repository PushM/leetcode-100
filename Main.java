public class Main  {
    public static void main(String[] args) {
        NormalArray solution = new NormalArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);

        // 在这里添加打印语句来查看旋转后的结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
