/**
 *  异常
1.继承Ecxeption和继承RuntimeException为什么差距这么大？
2.啥是捕获，啥是声明    
 */
class Demo{

   void show(){
        //如果在函数内抛出Exception //编译失败，因为编译器在检查语法是发生了错误。
        /**
        * 该程序中已经出现问题，Jave任务这个程序本身存在隐患，需要捕获或者声明出来
        （你要么把问题处理掉，要么把问题标识出来让调用知道）
        */
        // throw new Exception();

        //
        /**
         * 为什么抛出RuntimeException，不需要捕获，不需要声明呢？
          不是功能本身发生的异常，而是因为比如调用者传递参数错误而导致功能运行失败。
          这时也是问题，也需要异常来体现，但是这个异常是不需要声明出来的
          声明的目的，是为了让调用者进行处理。
          不声明的目的，是不让调用者进行处理。就是为了让程序停止，让调用者看到现象并进行代码的修正。
         */
        throw new RuntimeException();


        /**
         * 异常分两种：
           1.编译时异常，编译器会检测的异常
           2.运行时异常，编译器不会检测的异常，不需要声明（声明也可以，如果声明了，无外乎就是让调用者给出处理方式）
           ArrayIndexOutOfBoundsException
           IllegalArgumentException
           NullPointerException
           ClassCastException

         */
   }
}


class ExceptionDemo5 {
    public static void main(String[] args) {
        
    }
}

