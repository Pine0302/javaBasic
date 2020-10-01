
/*
jdk1.5以后提供多生产多消费的解决方案。

在java.util.concurrent.locks 软件包中提供相应的解决方案
Lock接口：比同步更厉害，有更多操作。lock():获取锁  unlock():释放锁;
		提供了一个更加面对对象的锁，在该锁中提供了更多的显示的锁操作。
		替代同步。

升级到JDK1.5,先把同步改成 Lock。

已经将旧锁替换成新锁，那么锁上的监视器方法(wait，notify，notifyAll)也应该替换成新锁的监视器方法。
而jdk1.5中将这些原有的监视器方法封装到了一个Condition对象中。
想要获取监视器方法，需要先获取Condition对象。

Condition对象的出现其实就是替代了Object中的监视器方法。
await();
signal();
signalAll();

将所有的监视器方法替换成了Condition。
功能和ThreadDemo10.java老程序的功能一样，仅仅是用新的对象。改了写法而已。
但是问题依旧；效率还是低。

希望本方可以唤醒对方中的一个。
老程序中可以通过两个锁嵌套完成，但是容易引发死锁。

新程序中，就可以解决这个问题，只用一个锁，
可以在一个锁上加上多个监视器对象。


*/
import java.util.concurrent.locks.*;

class Resource
{
	private String name;
	private int count = 1;

	//定义一个锁对象。
	private final Lock lock = new ReentrantLock();
	//获取锁上的Condition对象。为了解决本方唤醒对方的问题。可以一个锁创建两个监视器对象。

	private Condition produce = lock.newCondition();//负责生产。
	private Condition consume = lock.newCondition();//负责消费。
	
	//定义标记。
	private boolean flag = false;
	
	//1,提供设置的方法。
	public  void set(String name)//   
	{
		//获取锁。
		lock.lock();
		try{

			while(flag)
				try{produce.await();}catch(InterruptedException e){}// t1等  t2等
			this.name = name + count;//商品1  商品2  商品3
			count++;//2 3  4
			System.out.println(Thread.currentThread().getName()+"......生产者...."+this.name);//生产 商品1  生产商品2  生产商品3

			//将标记改为true。
			flag = true;
			//执行的消费者的唤醒。唤醒一个消费者就哦了。
			consume.signal();
		}finally{

			lock.unlock();//一定要执行。
		}
	}
	public  void out()// 
	{

		lock.lock();
		try{
		while(!flag)
			try{consume.await();}catch(InterruptedException e){}//t3等  //t4等
		System.out.println(Thread.currentThread().getName()+"....消费者...."+this.name);//消费 商品1
		//将标记该为false。
		flag = false;
		//
		produce.signal();
		}
		finally{
			lock.unlock();
		}
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




class ThreadDemo11
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

















