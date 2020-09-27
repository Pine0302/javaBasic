/*
案例二：毕老师用电脑讲课。
两个对象：
	老师：
		属性：姓名。
		行为：讲课。
	电脑：
		行为：运行。

考虑问题。
1，电脑蓝屏-->异常。

2，电脑冒烟-->异常。

*/
// 可以声明，让调用给出处理方式。
class LanPingException extends Exception
{
	LanPingException()
	{
		super();
	}
	LanPingException(String message)
	{
		super(message);
	}
}

class MaoYanException extends Exception
{
	MaoYanException()
	{
		super();
	}
	MaoYanException(String message)
	{
		super(message);
	}
}
/*
讲课中冒烟，问题可以临时解决，是冒烟问题没有直接处理，所以就使用throws声明。
但是发现，这个问题不应该属于讲课的问题。调用讲课方法的调用者是处理不了这个冒烟问题的。
该调用者能处理的应该是冒烟导致的课程进行不下去的问题。
应该在列出一个异常。课时停止异常。

*/
class NoPlanException extends Exception
{
	NoPlanException()
	{
		super();
	}
	NoPlanException(String message)
	{
		super(message);
	}
}


class NoteBook
{
	private int state = 2;
	public void run()throws LanPingException,MaoYanException//方法上可以通过throws声明多个异常。
	{
		System.out.println("笔记本电脑运行");
		if(state == 1)
			throw new LanPingException("电脑蓝屏了");

		if(state == 2)
			throw new MaoYanException("电脑冒烟了");
	}
	public void reset()
	{
		state = 0;
		System.out.println("电脑重启");
	}
}
class Teacher
{
	private String name;
	private NoteBook book;
	Teacher(String name)
	{
		this.name = name;
		book = new NoteBook();
	}
	//讲课。
	public void prelect()throws NoPlanException
	{
		/*
		调用到了声明异常的方法，在这里到底是捕获好呢？还是声明好呢？
		有具体的捕获处理方式吗？有，那就捕获，没有，那么声明。
		我可以处理，重启就可以了，重启是电脑的功能。
		*/
		try
		{
			book.run();//对于声明多个异常的方法，在处理，需要定义多个catch与之对应。
		}
		
		catch (LanPingException e)//LanPingException e = new LanPingException("电脑蓝屏了");
		{
			//重启。
			System.out.println(e.toString());//异常的名称+异常的信息。
//			e.printStackTrace();
			book.reset();
		}
		catch(MaoYanException e)//MaoYanException e = new MaoYanException("电脑冒烟了");
		{
			System.out.println(e.toString());
			test();
			//冒烟问题没有解决，继续声明throws出去。
//			throw e;
//			new 电脑维修部(book);//去修电脑。
//			book = new NoteBook();
			throw new NoPlanException(e.getMessage()+",课时停止");//异常转换。


		}
		System.out.println(name+"....讲课");
	}
	//留练习。
	public void test()
	{
		System.out.println("做练习");
	}
}

class ExceptionTest2 
{
	public static void main(String[] args) 
	{
		Teacher t = new Teacher("毕老师");
		try
		{
			t.prelect();
		}
		catch (NoPlanException e)
		{
			System.out.println(e.toString());
			System.out.println("换老师");
		}
		
		System.out.println("Hello World!");
	}
}



