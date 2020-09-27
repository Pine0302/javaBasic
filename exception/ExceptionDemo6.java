/**
 * 异常的声明和捕获   
  声明：将问题标识出来，报告给调用者
  如果函数内通过throw抛出了编译时异常，而未捕获，那么必须通过thrwos进行声明，让调用者去处理

  捕获：java中对异常有针对性的语句进行捕获
  语句：
  try
  {
      //需要被检测的代码语句。
  }
  catch(异常类 变量)  //参数
  {
      //异常的处理语句
  }
  finally
  {
      //一定会被执行的语句
  }

 */
class Demo{

  /**
   * 如果定义功能时有问题发生需要报告给调用者，可以通过在函数上使用throws关键字进行声明
   */
  void show() throws Exception
  {
      throw new Exception();
  }
}


class ExceptionDemo6 {
    /*
    public static void main(String[] args)  throws Exception   // 在调用者上继续声明，最终到虚拟机JVM
    {
        Demo d = new Demo();
        d.show(); //当调用了声明异常的方法时，必须有处理方式，要么捕获要么声明
        System.out.println("show");
    }
    */

    public static void main(String[] args) 
    {
        Demo d = new Demo();
        try{
            d.show(); //当调用了声明异常的方法时，必须有处理方式，要么捕获要么声明
        }
        catch(Exception e)  //括号中需要定义什么呢？对方抛出的是什么问题，在括号中就定义什么问题的引用
        {
          System.out.println("异常发生了");
        }
        System.out.println("show");
    }
}

