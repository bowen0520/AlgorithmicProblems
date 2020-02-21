package leetcode.test0251to0300;

public class Leetcode278 extends VersionControl {
	
	public static void main(String[] args) {
		long n = 2147483648l;
		int m = 2147483647;
		
		System.out.println(m);
		System.out.println((m+n)/2+"_______");
		
		int t = Long.valueOf((n+1)/2).intValue();
		System.out.println(t);
		System.out.println(new Leetcode278().firstBadVersion(m));
	}
	
	
	public int firstBadVersion(int n) {
        int left = 1;
        long right = n + 1l;
        while(left<right) {
        	int mid = Long.valueOf((left+right)/2).intValue();
        	if(!isBadVersion(mid)) {
        		left = mid + 1;
        	}else {
        		if(!isBadVersion(mid-1)) {
        			return mid;
        		}
        		right = mid;
        	}
        }
        return left;
    }
}

class VersionControl{
	public boolean isBadVersion(int version) {
		if(version == 2147483647) return true;
		return false;
	}
} 


/*
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

示例:

给定 n = 5，并且 version = 4 是第一个错误的版本。

调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true

所以，4 是第一个错误的版本
*/
