package interviewquestions.meituan;

import java.util.Scanner;

public class Test2 {
	
	private int n;
	
	public Test2(int n) {
		this.n = n;
		PrizePool prizePool = new PrizePool();
		bonus(prizePool);
		coupon(prizePool);
		contribution(prizePool);
		for(int i = 1;i<=n;i++) {
			prizePool.num = i;
		}
	}

	    

	  public void bonus(PrizePool prizePool) { 
		  new MyThread1(prizePool).start();
	  }  // 仅能打印A，表示发放积分

	  public void coupon(PrizePool prizePool) { new MyThread2(prizePool).start(); }  // 仅能打印B，表示发放优惠券

	  public void contribution(PrizePool prizePool) { new MyThread3(prizePool).start(); }  // 仅能打印C，表示发放贡献值
	  public static void main(String[] args) {
		  Scanner s = new Scanner(System.in);
		  int n = s.nextInt();
		new Test2(n);
	}

}

class PrizePool {
	static int num = 0;

    public void send(String input) {

        System.out.print(input);

    }

}

class MyThread1 extends Thread{
	PrizePool pp;

	public MyThread1(PrizePool pp) {
		this.pp = pp;
	}
	
	@Override
	public void run() {
		while(true) {
				synchronized (pp) {
					if(pp.num%2==1) {
						pp.send("A");
						pp.notifyAll();
					}else {
						try {
							pp.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			
		}
	}
}
class MyThread2 extends Thread{
	PrizePool pp;

	public MyThread2(PrizePool pp) {
		this.pp = pp;
	}
	
	@Override
	public void run() {
		while(true) {
				synchronized (pp) {
					if(pp.num%2==0&&pp.num/2%2==1) {
						pp.send("B");
						pp.notifyAll();
					}else {
						try {
							pp.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		}
	}
}

class MyThread3 extends Thread{
	PrizePool pp;
	int a = 0;

	public MyThread3(PrizePool pp) {
		this.pp = pp;
	}
	
	@Override
	public void run() {
		while(true) {
			while(pp.num!=a) {
				synchronized (pp) {
					if(pp.num%2==0&&pp.num/2%2==0) {
						pp.send("C");
						a = pp.num;
						pp.notifyAll();
					}else {
						try {
							pp.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}

