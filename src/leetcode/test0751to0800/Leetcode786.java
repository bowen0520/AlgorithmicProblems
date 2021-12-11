package leetcode.test0751to0800;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    	List<Book> list = new ArrayList<Book>();

    	PriorityQueue<Book> pq = new PriorityQueue<Book>((x, y) -> x.value-y.value>0 ? 1 : -1);
    	Set<Book> set = new HashSet<Book>();
    	int step = 1;
    	Book book = new Book(0, arr.length - 1, ((double) arr[0])/ arr[arr.length - 1] );
    	pq.offer(book);
    	set.add(book);
    	while(step < k) {
    		Book temp = pq.poll();
    		
    		Book book1 = new Book(temp.i + 1, temp.j, ((double) arr[temp.i + 1])/ arr[temp.j] );
    		Book book2 = new Book(temp.i, temp.j - 1, ((double) arr[temp.i])/ arr[temp.j - 1] );
    		
    		if(!set.contains(book1)) {
    			pq.offer(book1);
                set.add(book1);
    		}
    		if(!set.contains(book2)) {
    			pq.offer(book2);
                set.add(book2);
    		}
    		step++;
    	}
    	Book an = pq.poll();
    	return new int[] {arr[an.i], arr[an.j]};
    }
    
    public void add(List<Book> list, Book book) {
    	for(int i = 0; i < list.size(); i++) {
    		if(list.get(i).value > book.value) {
    			list.add(i, book);
    			return;
    		}
    	}
    	
    	list.add(book);
    }
    
    class Book{
    	int i;
    	int j;
    	double value;
    	
    	public Book(int i, int j, double value){
    		this.i = i;
    		this.j = j;
    		this.value = value;
    	}
    	
    	@Override
    	public int hashCode() {
    		
    		return (i + "" + j).hashCode();
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    		Book temp = (Book) obj;
    		
    		if(this.i == temp.i && this.j == temp.j) {
    			return true;
    		}
    		return false;
    	}
    }
}

