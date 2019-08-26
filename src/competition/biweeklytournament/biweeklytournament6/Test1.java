package competition.biweeklytournament.biweeklytournament6;

public class Test1 {
	public static void main(String[] args) {
		//int[] nums = {2,4,5,5,5,5,5,6,6};
		//int target = 5;
		
		int[] nums = {2,4,5,5,5,5,5,6,6}; 
		int target = 5;
		/*
		 * int[] nums = {10,100,101,101}; int target = 101;
		 */
		System.out.println(new Test1().isMajorityElement(nums, target));
	}
	public boolean isMajorityElement(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;
        boolean flag = true;
        while(flag){
            if(nums[min]<target){
                min++;
            }
            if(nums[max]>target){
                max--;
            }
            if((max-min+1)<=(nums.length)/2){
                return false;
            }
            if(nums[min]==target&&nums[max]==target) {
            	flag = false;
            }
            
        }
        return true;
    }
}
