
//两个客户到一个银行去存钱，每个客户一次存100，存3次。
//问题：该程序是否有安全问题，如果有，写出分析过程，并定义解决方案。

/*

发现运行结果：
sum=200
sum=300
sum=400
sum=200
sum=500
sum=600

打印错乱，不关心，但是发现数值错误，没有100.
运行了几次发现有对的。
sum=100
sum=300
sum=400
sum=200
sum=500
sum=600

说明多线程的随机性造成了安全问题发生。
哪的问题啊？
1，既然是多线程的问题，必须问题发生在线程任务内。
2，任务代码中是否有共性数据呢？有的，b对象的中的sum。
3，是否有对sum进行多次运算呢？有！

加同步就搞定。
*/

//描述银行。
class Bank
{
	private int sum;
	private Object obj = new Object();
	public void add(int num)
	{	
		synchronized(obj)
		{
			sum = sum + num;
			System.out.println("sum="+sum);//每存一次，看到银行金额变化。
		}
	}
}
class Consumer implements Runnable
{
	private Bank b = new Bank();
	public void run()
	{
		for(int x=0 ; x<3; x++)
		{
			b.add(100);//一次存100.循环3次，
		}
	}
}
class ThreadTest
{
	public static void main(String[] args)
	{
		Consumer c = new Consumer();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();

	}
}
