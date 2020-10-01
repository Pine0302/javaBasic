

class Test implements Runnable
{
	private boolean flag;
	Test(boolean flag)
	{
		this.flag = flag;
	}

	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(MyLock.LOCKA)
				{
					System.out.println(Thread.currentThread().getName()+"...if......locka");
					synchronized(MyLock.LOCKB)
					{
						System.out.println(Thread.currentThread().getName()+"...if......lockb");
					}
				}
			}
		}
		else
		{
			while(true)
			{
				synchronized(MyLock.LOCKB)
				{
					System.out.println(Thread.currentThread().getName()+"...else......lockb");
					synchronized(MyLock.LOCKA)
					{
						System.out.println(Thread.currentThread().getName()+"...else......locka");
					}
				}
			}
		}
	}
}
//定义一个用于存储锁对象类。
class MyLock
{
	public static final Object LOCKA = new Object();
	public static final Object LOCKB = new Object();
}

class DeadLockTest 
{
	public static void main(String[] args) 
	{
		//创建两个线程任务。
		Test t1 = new Test(true);
		Test t2 = new Test(false);
		
		Thread t11 = new Thread(t1);
		Thread t22 = new Thread(t2);
		t11.start();
		t22.start();

	}
}
