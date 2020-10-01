/*
同步的另一种体现形式：同步函数。

同步函数使用的锁是哪个？
经过分析：大概猜的是this，因为函数必须被对象调用。

验证：
写一个同步代码块，写一个同步函数，如果同步代码块中的锁对象和同步函数中的锁对象是同一个，
就同步了，就没有错误的数据了。如果不是同一个锁对象，就不同步出现错误数据。

让两个线程，一个线程在同步代码块中执行，一个线程在同步函数中执行。

总结：同步函数使用的锁时this。

同步函数和同步代码块有什么区别吗？

同步函数使用的锁是固定的this。当线程任务只需要一个同步时完全可以使用同步函数。
同步代码块使用的锁可以是任意对象。当线程任务中需要多个同步时，必须通过锁来区分，这时必须使用同步代码块。
同步代码块较为常用。



*/

class Ticket implements Runnable
{
	private int tickets = 100;
	private Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag){
			while(true){
				synchronized(this){
					if(tickets>0){
						try{Thread.sleep(10);}catch(InterruptedException e){}
						System.out.println(Thread.currentThread().getName()+"...obj..."+tickets--);//打印线程名称。
					}
				}
			}
		}
		else{
			while(true){
				this.sale();
			}
		}
	}

	public synchronized void sale()//同步函数,使用的锁对象 this。
	{
		if(tickets>0)
		{
			try{Thread.sleep(10);}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+"...sale..."+tickets--);//打印线程名称。
		}
	}
}
class ThreadDemo4 
{
	public static void main(String[] args) 
	{
		Ticket t = new Ticket();

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		try{Thread.sleep(10);}catch(InterruptedException e){}
		//切换标记,之前，让主线程停一会，这时就只有一个t1线程在，它就会执行同步代码块。
		t.flag = false;

		t2.start();
	}
}
