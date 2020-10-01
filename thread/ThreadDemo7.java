/*
同步的另一个弊端：

情况之一：当线程任务中出现了多个同步(多个锁)时，如果同步中嵌套了其他的同步。
这时容易引发一种现象：死锁。
这种情况能避免就避免掉。

//Thread-0
synchronized(obj1)
{
	-->thread-0  obj1
	synchronized(obj2)
	{
		
	}

}
//Thread-1
synchronized(obj2)
{
	Thread-1 obj2
	synchronized(obj1)
	{
		
	}

}


*/


class Ticket implements Runnable
{
	private  int tickets = 100;
	private Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag){
			while(true){
				synchronized(obj){
					sale();//this lock;
				}
			}
		}
		else{
			while(true){
				this.sale();
			}
		}
	}

	public synchronized void sale()//this lock
	{
		synchronized(obj)//obj lock
		{
			if(tickets>0)
			{
				try{Thread.sleep(10);}catch(InterruptedException e){}
				System.out.println(Thread.currentThread().getName()+"...sale..."+tickets--);//打印线程名称。
			}
		}
	}
}
class ThreadDemo7 
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


