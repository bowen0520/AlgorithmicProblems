package leetcode.test0501to0550;

public class Leetcode537 {
    public String complexNumberMultiply(String num1, String num2) {
        int[] nums1 = getNums(num1);
        
        int[] nums2 = getNums(num2);
        
        int a = nums1[0] * nums2[0] - nums1[1] * nums2[1];
        int b = nums1[0] * nums2[1] + nums1[1] * nums2[0];
        return a + "+" + b + "i";
    }
    
    public int[] getNums(String num) {
        String[] nums = num.split("[+]");
        
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1].substring(0, nums[1].length() - 1));
        return new int[] {a, b};
    }
}
