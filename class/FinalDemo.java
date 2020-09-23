/**
 * 集成的弊端:打破封装性
 * 不让其他类集成该类,就不会有重写
 * 怎么实现呢?通过Java中的一个关键字来实现,final(最终化)
 * [final关键字]
 * 是一个修饰符,可以修饰类,方法,变量(成员变量,局部变量,静态变量).
 * [特点]
 * 1.final修饰的类是一个最终类,不能再派生子类
 * 2.final修饰的方法是最终方法,不可以被重写
 * 3.final修饰的变量是一个常量,只能被赋值一次
 * [什么时候会在程序中定义final常量呢?]
 * 当程序中一个数据使用时时固定不变的,这时为了增加阅读性,可以给该数据起个名字.
 * 这就是变量,为了保证这个变量的值不被修改,加上final修饰,这就是一个阅读性很强的常量/
 * 书写规范,被final修饰的常量名所有字母都是大写的,如果由多个单词组成,单词间通过 _ 连接
 */
/*final*/ class Fu 
{
   /*final()*/ void show()
   {
       //调用到一些系统的功能
       //功能的内容是不可以改变的
       method();
   }

   private void method(){

   }
}

class Zi extends Fu
{
  void show(){
      final int count = 21;
      System.out.println(count);
  }
}

class FinalDemo {
    public static void main(String[] args) {
     
    }
}

