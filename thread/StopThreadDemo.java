

//演示停止线程。
class Demo implements Runnable
{
	private boolean flag = true;
	public synchronized void run()
	{
		while(flag)
		{
			try
			{
				wait();//t1  t2
			}
			catch (InterruptedException e)
			{
				System.out.println(Thread.currentThread().toString()+"....."+e.toString());
				changeFlag();
			}

			System.out.println(Thread.currentThread().getName()+"----->");
		}
	}
	//对标记的修改方法。
	public void changeFlag()
	{
		flag = false;
	}
}


class StopThreadDemo 
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();

		Thread t1 = new Thread(d,"旺财");
		Thread t2 = new Thread(d,"小强");
		t1.start();
		//将t2标记为后台线程，守护线程。
		//t2.setDaemon(true);
		t2.start();

		int x = 0;
		while(true)
		{
			if(++x == 50)//条件满足。
			{
//				d.changeFlag();//改变线程任务代码的标记，让其他线程也结束。
				//对t1线程对象进行中断状态的清除，强制让其恢复到运行状态。
				t1.interrupt();
				//对t2线程对象进行中断状态的清除，强制让其恢复到运行状态。
				t2.interrupt();

				break;//跳出循环，主线程可以结束。
			}
			System.out.println("main-------->"+x);
		}

		System.out.println("over");
	}
}
