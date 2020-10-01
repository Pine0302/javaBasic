class ThreadTest3
{
	
	public static void main(String[] args)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				System.out.println("runnable run");
			}
		}){
			public void run()
			{
				System.out.println("subthread run");//执行。
			}
		}.start();
	}



}