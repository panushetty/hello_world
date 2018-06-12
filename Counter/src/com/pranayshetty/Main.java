package com.pranayshetty;

public class Main {

	public static void main(String[] args) {
		Countdown countdown=new Countdown();
		CountdownThread t1=new CountdownThread(countdown);
		CountdownThread t2=new CountdownThread(countdown);
		t1.setName("yo");
		t2.setName("oy");
		t1.start();
		t2.start();

	}
	


}


class Countdown{
	private int i;
	public void doCountdown() {
		String color;
		switch(Thread.currentThread().getName()) {
			case "yo":
				color="<<<<<<<<";
				break;
			case "oy":
				color=">>>>>>>>";
				break;
			default:
				color="c";
				break;
		}
		synchronized(this) {
			for( i=10;i>0;i--) {
				System.out.println(color+" "+Thread.currentThread().getName()+"  "+i);
			}	
		}
		
	}
}


class CountdownThread extends Thread{
	private Countdown threadCountdown;

	public CountdownThread(Countdown threadCountdown) {
		this.threadCountdown = threadCountdown;
	}
	
	public void run() {
		threadCountdown.doCountdown();
	}
	
	
}
