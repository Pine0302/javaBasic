
/*
try catch finally 组合方式：

1，
try catch : 对代码进行异常检测，并对检测的异常传递给catch处理。
			异常捕获处理。
void show()//不用throws 
{
	try{
	throw new Exception();
	}catch(Exception e)
	{
	
	}
}

2，
try finally : 对代码进行异常检测，检测到异常后因为没有catch，所以一样会被默认jvm抛出。
			异常是没有捕获处理的。但是功能所开启资源需要进行关闭，所有finally。
			只为关闭资源。

void show()//需要throws 
{
	try{
	throw new Exception();
	}finally
	{
	
	}
}

3，
try catch finally
检测异常，并传递给catch处理，并定义资源释放。

4，try catch1 catch2 catch3......

*/





class ExceptionDemo10 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
