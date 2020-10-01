import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java api 1.8 多线程 多生产者多消费者实例
 */
class BoundedBuffer {
	final Lock lock = new ReentrantLock();//锁
	final Condition notFull  = lock.newCondition(); //生产
	final Condition notEmpty = lock.newCondition(); //消费
 
	final Object[] items = new Object[100];//存储商品的容器。
	int putptr/*生产者使用的角标*/, takeptr/*消费者使用的角标*/, count/*计数器*/;
 
	 /*生产者使用的方法，往数组中存储商品*/
	public void put(Object x) throws InterruptedException {
	  lock.lock();
	  try {
		while (count == items.length) //判断计数器是否已到数组长度。满了。
		  notFull.await();//生产就等待。
 
		items[putptr] = x; //按照角标将商品存储到数组中
		System.out.println(Thread.currentThread().getName()+"...生产......"+putptr);
		if (++putptr == items.length) //如果存储的角标到了数组的长度，就将角标归零。
			 putptr = 0;
		++count;//计数器自增。
		notEmpty.signal();//唤醒一个消费者
	  } finally {
		lock.unlock();
	  }
	}
 
	public Object take() throws InterruptedException {
	  lock.lock();
	  try {
		while (count == 0) //如果计数器为0，说明没有商品，消费者等待。
		  notEmpty.await();
		Object x = items[takeptr]; //从数组中通过消费者角标获取商品。
		System.out.println(Thread.currentThread().getName()+"......消费..."+takeptr);
		if (++takeptr == items.length) //如果消费的角标等于了数组的长度，将角标归零。
			takeptr = 0;
		--count;//计数器自减。
		notFull.signal();//唤醒生产者。
		return x;
	  } finally {
		lock.unlock();
	  }
	} 
}

class Producer implements Runnable{
	private BoundedBuffer boundedBuffer;
	Producer(BoundedBuffer boundedBuffer){
		this.boundedBuffer = boundedBuffer;
	}
	public void run(){
		while(true){
			try {this.boundedBuffer.put(this.boundedBuffer.items[this.boundedBuffer.putptr]);} catch (InterruptedException e) {}
		}
	}
}
  
class Consumer implements Runnable{

	private BoundedBuffer boundedBuffer;
	Consumer(BoundedBuffer boundedBuffer){
		this.boundedBuffer = boundedBuffer;
	}
	public void run(){
		while(true){
			try {this.boundedBuffer.take();	} catch (Exception e) {}
		}
	}
}

class ThreadDemo12
{
	public static void main(String[] args)
	{
		BoundedBuffer boundedBuffer = new BoundedBuffer();
		Producer producer1 = new Producer(boundedBuffer);
		Producer producer2 = new Producer(boundedBuffer);
		Consumer consumer1 = new Consumer(boundedBuffer);
		Consumer consumer2 = new Consumer(boundedBuffer);
		Thread p1 = new Thread(producer1);
		Thread p2 = new Thread(producer2);
		Thread c1 = new Thread(consumer1);
		Thread c2 = new Thread(consumer2);
		p1.start();
		p2.start();
		c1.start();
		c2.start();

	}
}
