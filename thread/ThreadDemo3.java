
/*
案例：售票的例子。

售票的动作需要同时执行，所以使用多线程技术。


发生了线程安全问题：出现了错误的数据。0 -1 -2 

问题产生的原因；
1，线程任务中在操作共享的数据。
2，线程任务操作共享数据的代码有多条(运算有多个)。

解决思路：
只要让一个线程在执行线程任务时将多条操作共享数据的代码执行完，
在执行过程中，不要让其他线程参与运算。就哦了。

代码体现呢？
Java中解决此问题通过代码块来完成的。
这个代码块：同步代码块 synchronized
格式：
synchronized(对象)
{
	//需要被同步的代码。
}

同步好处：
解决多线程安全问题。

同步弊端：
降低了程序的性能。


同步前提：
必须保证多个线程在同步中使用的是同一个锁。
解决了什么问题?
当多线程安全问题发生时，加入了同步后，
问题依旧，就要通过这个同步的前提来判断同步是否写正确。


*/

class Ticket implements Runnable
{
	
	private int ticketNum;
	
	Ticket(int ticketNum)
	{
		this.ticketNum = ticketNum;
	}


	private Object obj = new Object();

	//售票的动作，这个动作需要被多线程执行，那就是线程任务代码。需要定义run方法中。
	//线程任务中通常都有循环结构。
	public void run()
	{
		while(true){
			synchronized(obj)    //obj 相当于锁  （火车的卫生间-->同步锁）
			{
				if(this.ticketNum>0){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						
					}
					System.out.println(Thread.currentThread().getName()+"......."+ticketNum--);
				}
			}
		}

		
	}
}

class ThreadDemo3
{
	public static void main(String[] args) 
	{
		//创建Runnable子类的对象。注意它并不是线程对象。
		Ticket t = new Ticket(1000);
		//创建Thread类的对象，将Runnable接口的子类对象作为参数传递给Thread类的构造函数。
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);

		//将线程启动。
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
