package competition.oneweekrace.oneweekrace159;

public class Test4 {
	public static void main(String[] args) {
		int num = new Test4().getGY(12);
		System.out.println(num);
	}
	
	public int getGY(int val) {
		int num = 1;
		int nval = val;
		int count = 0;
		for(int i = 2;nval>1;) {
			if(nval%i==0) {
				count++;
				nval = nval/i;
			}else {
				i++;
				num = num * (count + 1);
				count = 0;
			}
		}
		return num * (count + 1);
	}
}
