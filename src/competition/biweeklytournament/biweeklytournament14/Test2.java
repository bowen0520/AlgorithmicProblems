package competition.biweeklytournament.biweeklytournament14;

public class Test2 {
	public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
		int[] sum = new int[nodes];
		getNodeNum(0, parent, value,sum);
		boolean[] books = new boolean[nodes];
		for(int i = 0;i<nodes;i++) {
			if(!books[i]) {
				if(sum[i]==0) {
					getBooks(i, parent, books);
				}
			}
		}
		int count = 0;
		for(int i = 0;i<nodes;i++) {
			if(!books[i]) {
				count++;
			}
		}
		return count;
        
    }
	public int getNodeNum(int nodes, int[] parent, int[] value,int[] sum) {
		int num = value[nodes];
		for(int i = 0;i<parent.length;i++) {
			if(parent[i]==nodes) {
				num += getNodeNum(i, parent, value,sum);
			}
		}
		sum[nodes] = num;
		return num;
	}
	
	public void getBooks(int nodes, int[] parent, boolean[] books) {
		books[nodes] = true;
		for(int i = 0;i<parent.length;i++) {
			if(parent[i]==nodes) {
				getBooks(i, parent, books);
			}
		}
	}
}
