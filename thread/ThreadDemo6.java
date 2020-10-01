
//饿汉式。  多线程并发饿汉式没问题。
class Single
{
	private static final Single s = new Single();

	private Single(){}

	public static Single getInstance()
	{
		return s;
	}
}

//懒汉式。
class Single
{
	private static  Single s = null;

	private Single(){}

	/*
	并发访问会有安全隐患，所以加入同步机制解决安全问题。
	但是，同步的出现降低了效率。
	可以通过双重判断的方式，解决效率问题，减少判断锁的次数。

	*/
	public static  Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)
			{
				if(s==null)
		//			-->0 -->1
					s = new Single();
			}
		}
		return s;
	}
}



class Demo implements Runnable
{
	public void run()
	{
		Single.getInstance();
	}
}


class ThreadDemo6 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
