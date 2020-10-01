
class Demo implements Runnable
{

	public void run()
	{
		for(int x=1; x<=40; x++)
		{
			System.out.println(Thread.currentThread().getName()+"------>"+x);
			Thread.yield();//线程临时暂停。将执行权释放，让其他线程有机会获取执行权。
		}
	}

}

class JoinThreadDemo 
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);

		t1.start();
		t2.start();
		//主线程执行到这里，知道t1要加入执行，主线程释放了执行权，
		//执行资格并处于冻结状态，什么时候恢复呢？等t1线程执行完。
//		try{t1.join();}catch(InterruptedException e){}//用于临时加入一个运算的线程。让该线程运算完，程序才会继续执行。

		for(int x=1; x<=50; x++)
		{
			System.out.println("main---------->"+x);
		}
		System.out.println("over");
	}
}
