package competition.biweeklytournament.biweeklytournament6;

public class Test2 {
	public static void main(String[] args) {
		int[] data = {1,0,1,0,1};
		System.out.println();
	}
	public int minSwaps(int[] data) {
		int count = 0;
		int[] books = new int[data.length];
        for(int i = 0;i<data.length;i++) {
        	if(data[i]==1) {
        		count++;
        	}
        	books[i] = count;
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0;j<data.length-count+1;j++) {
        	if(data[j]==0) {
        		continue;
        	}
        	int book = books[j+count-1]-books[j];
        	if((count-book)<min) {
        		min = count-book;
        	}
        }
        return min;
    }
}
