

/*
通过代码来演示之前和之后的区别。

在之前的代码中，jvm启动后，必然有一个执行路径(线程)从main方法开始的。一直执行到main方法结束。
这个线程在java中称之为主线程。

当主线程在这个程序中执行时，如果遇到了循环而导致在指定为停留时间过长，
无法执行下面的程序。
可不可以实现一个主线程负责执行其中一个循环，由另一个线程负责其他代码的执行。
实现多部分代码同时执行。
这就是多线程技术可以解决的问题。

该如何创建线程呢？

通过API中的英文Thread的搜索，查到Thread类。
通过阅读Thread类中的描述。

创建线程有两种方式：
1，继承Thread类。★★★★★
	1.1 定义一个类继承Thread。
	1.2 重写run方法。
	1.3 创建子类对象，就是创建线程对象。
	1.4 调用start方法，开启线程并让线程执行，同时还会告诉jvm去调用run方法。
	
为什么要这么做？
继承Thread类：因为Thread类描述线程事物，具备线程应该有功能。
那为什么不只讲创建Thread类的对象呢？
Thread t1 = new Thread();
t1.start();//这么做没有错，但是该start调用的时Thread类中的run方法，
而这个run方法没有做什么事情，更重要的是这个run方法中并没有定义我们需要让线程执行的代码。

创建线程的目的是什么？是为了建立单独的执行路径，让多部分代码实现同时执行。
也就是说线程创建并执行需要给定的代码(线程的任务)。
对于之前所讲的主线程，它的任务定义在main函数中。
自定义线程需要执行的任务都定义在run方法中。
Thread类中的run方法内部的任务并不是我们所需要，只要重写这个run方法，
既然Thread类已经定义了线程任务的位置，只要在位置中定义任务代码即可。
所以进行了重写run方法动作。


多线程执行时，在栈内存中，其实每一个执行线程都有一片自己所属的栈内存空间。
进行方法的压栈和弹栈。

当执行线程的任务结束了，线程自动在栈内存中释放了。
但是当所有的执行线程都结束了，那么进程就结束了。


//获取线程名称：
Thread：currentThread()获取当前线程对象。怎么名称呢?getName();
Thread.currentThread().getName();

主线程的名称： main
自定义的线程： Thread-1  线程多个时，数字顺延。Thread-2......
*/

class Demo extends Thread
{
	private String name;
	Demo(String name)
	{
		this.name = name;	
	}
	public void run()
	{
        
		int[] arr = new int[3];
        System.out.println(arr[4]);
        
		for(int x=1; x<=200; x++)
		{
			System.out.println("name="+name+"..."+Thread.currentThread().getName()+"..."+x);
		}
	}
}


class  ThreadDemo
{
	public static void main(String[] args) 
	{
		//创建了两个线程对象。
		Demo d1 = new Demo("小强");
		Demo d2 = new Demo("旺财");
		d2.start();//将d2这个线程开启。
		d1.run();//由主线程负责。
		
		/*
		面试题：线程对象调用 run方法和调用start方法区别？
		调用run方法不开启线程。仅是对象调用方法。
		调用start开启线程，并让jvm调用run方法在开启的线程中执行。
		*/
	}
}
