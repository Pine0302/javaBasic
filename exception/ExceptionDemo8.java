/*
需求：有一些特定的代码无论异常是否发生，都需要执行。
因为异常会引发程序跳转，导致有写语句执行不到。无法满足这个需求。
异常捕获处理时java提供解决方案。
try catch finally
finally就是解决这个问题的，这个代码块中存放的代码都是一定会被执行的。


应用场景；


定义一个功能往数据库中添加数据。

void add(Data data)throws NoAddException
{
	//1,连接数据库。
	try{
	//2,添加数据。//添加数据时发生了异常情况。throw new SQLException();程序跳转，就执行不到断开连接。
				//而断开连接必须要执行，因为不执行，连接资源在浪费。
				//无论是否发生问题，都需要执行断开连接的动作，从而释放资源。
	}catch(SQLException e)
	{
		//解决数据库的问题。
		//同时将问题告诉调用者。
		throw new NoAddException();
	}
	finally
	{
		//3,断开连接。
	}

}

总结：finally到底什么时候用？
只要程序中使用到了具体的资源(数据库连接，IO资源，网络连接socket等)
需要释放，都必须定义在finally中。你在定义程序，只要问题发生与否，
指定程序都需要执行时，就定义finally中。



*/

class NoShowException extends Exception
{
	NoShowException(String message)
	{
		super(message);
	}
}

class Demo
{
	void show(int num)throws NoShowException
	{
		if(num<0)
			throw new NoShowException(num+",数值是非法的");
		System.out.println("show ....."+num);
	}
}

class ExceptionDemo9
{
	public static void main(String[] args)
	{
		/*
		Demo d  = new Demo();
		//因为调用到了声明异常的show方法，所以调用者要给处理方式，要么继续声明，要么捕获。
		try
		{
			d.show(-5);
		}
		catch (NoShowException ex)
		{
			System.out.println(ex.toString());//打印是异常名称+异常信息。

			//如果异常发生，处理完毕后，希望功能结束。
//			return ;

			//注意：有一种情况发生，finally也不执行。
			System.exit(0);//退出Jvm。
		}
		finally
		{
			System.out.println("hello");
		}
		System.out.println("over");
		*/

		Test t = new Test();
		int num = t.show(-4);
		System.out.println("num="+num);


	}
}


class Test
{
	int show(int num)
	{
	
		try{
			if(num<0)
				throw new Exception();
			return 4;
		}catch(Exception e)
		{
			System.out.println(e.toString());
			return 200;
		}
		finally
		{
			System.out.println("finally run");
			return 100;
		}
	}
}
