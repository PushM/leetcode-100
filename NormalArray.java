
class NormalArray {
    /*
    (1)再使用一个数组进行翻转，时间复杂度和空间复杂度都是O(n)
    (3)先全部翻转，之后0-k翻转，k到n-1翻转，时间复杂度O(n)空间复杂度O(1)
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0, nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public static void reverse(int[] nums, int start,int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
