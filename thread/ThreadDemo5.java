

/*
static 同步函数，使用的锁不是this，而是字节码文件对象, 类名.class   
*/
class Ticket implements Runnable
{
	private static int tickets = 100;
	private Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		if(flag){
			while(true){
				synchronized(Ticket.class){
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

	public static synchronized void sale()//
	{
		if(tickets>0)
		{
			try{Thread.sleep(10);}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+"...sale..."+tickets--);//打印线程名称。
		}
	}
}
class ThreadDemo5 
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
