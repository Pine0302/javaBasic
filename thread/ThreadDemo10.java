
/*
多生产多消费。
问题1；生产了商品没有被消费，同一个商品被消费多次。
Thread-0......生产者....面包2499//没有被消费。
Thread-1......生产者....面包2500
Thread-3....消费者....面包2500

被唤醒的线程没有判断标记，造成问题1的产生。
解决：只要让被唤醒的线程必须判断标记就可以了。将if判断标记的方式改为while判断标记。记住：多生产多消费，必须时while判断条件。


问题2：发现while判断后，死锁了。
原因：生产方唤醒了线程池中生产方的线程。本方唤醒了本方。
解决：希望本方要唤醒对方，没有对应的方法，所以只能唤醒所有。


其实还有一些遗憾的，效率低了。
*/

class Resource
{
	private String name;
	private int count = 1;

	//定义标记。
	private boolean flag = false;
	
	//1,提供设置的方法。
	public synchronized void set(String name)//   
	{

		while(flag)
			try{this.wait();}catch(InterruptedException e){}// t1等  t2等
		//给成员变量赋值并加上编号。
		this.name = name + count;//商品1  商品2  商品3
		//编号自增。
		count++;//2 3  4
		//打印生产了哪个商品。
		System.out.println(Thread.currentThread().getName()+"......生产者...."+this.name);//生产 商品1  生产商品2  生产商品3

		//将标记改为true。
		flag = true;
		//唤醒消费者。
		this.notifyAll();
	}
	public synchronized void out()// 
	{
		while(!flag)
			try{this.wait();}catch(InterruptedException e){}//t3等  //t4等
		System.out.println(Thread.currentThread().getName()+"....消费者...."+this.name);//消费 商品1
		//将标记该为false。
		flag = false;
		//唤醒生产者。
		this.notifyAll();
	}
}

//2,描述生产者。
class Producer implements Runnable
{
	private Resource r ;
	// 生产者一初始化就要有资源，需要将资源传递到构造函数中。
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("面包");
		}
	}
}

//3,描述消费者。
class Consumer implements Runnable
{
	private Resource r ;
	// 消费者一初始化就要有资源，需要将资源传递到构造函数中。
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}




class ThreadDemo10
{
	public static void main(String[] args) 
	{
		//1,创建资源对象。
		Resource r = new Resource();

		//2,创建线程任务。
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		//3,创建线程。
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}





























