/*
异常在继承或者实现中的使用细节：★★★★★
1,子类覆盖父类方法时，如果父类的方法声明异常，子类只能声明父类异常或者该异常的子类，或者不声明。
2,当父类方法声明多个异常时，子类覆盖时只能声明多个异常的子集。
3,当被覆盖的方法没有异常声明时，子类覆盖时时无法声明异常的。
	举例：父类存在这种情况，接口也有这种情况，
	问题：接口中没有声明异常，而实现的子类覆盖方法时发生了异常，怎么办？
		　无法进行throws声明，只能catch的捕获。万一问题处理不了呢？catch中继续throw抛出，但是只能将异常转换成RuntimeException子类抛出。

	Interface Inter
	{
		public void show();
	}
	class Demo implement Inter
	{
		public void show()
		{
			try{
				throw new Exception();
			}catch(Exception e)
			{
				code...;
				throw new RuntimeException("");// 告知调用者问题所在。
			}
		}
	}


Exception
	|--AException
		|--AAException
	|--BException
*/
class AException extends Exception
{
}
class BException extends Exception
{
}
class AAException extends AException
{
}


class Fu
{
	void show()
	{
		
	}
}
/*
class Tool
{
	void method(Fu f)//Fu f = new Zi();
	{
		try
		{
			f.show();
		}
		catch (AException ex)//AException ex = new AAException();
		{
		}
	}
}
Tool t = new Tool();
//t.method(new Fu());
t.method(new Zi());
*/

class Zi extends Fu
{
	void show()throws RuntimeException
	{
		
	}
}


class ExceptionDemo11 
{
	public static void main(String[] args) 
	{
		Zi z = new Zi();
		try{
		z.show();
		}catch(RuntimeException e)
		{}
	}
}
