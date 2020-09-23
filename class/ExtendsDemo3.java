/**
 * 子父类构造函数的特点 / 子类实例化过程
 * 当子父类都有构造函数时，发现结果为：
 * fu constructor run
 * zi constructor run
 * 先执行了父类的构造函数，再执行子类的构造函数
 * 为啥呢？
 * 应为子类所有的构造函数中的第一行都有一句隐式语句 super(); //默认调用的是父类中的空参数的构造函数
 * 
 * 子类中的构造函数为什么有一句隐式语句super() 呢？
 * 原因：子类会继承父类中的内容，所以子类在初始化时必须先到父类中执行父类的初始化动作才可以更方便的使用父类中的内容
 * 当父类中没有空参数构造函数时，子类的构造函数必须通过显示的super语句来指定要访问的父类中的构造函数
 * 
 */
class Fu
{
    Fu(int x)
    {
        System.out.println("fu constructor run...."+x); 
    } 
}

class Zi extends Fu
{
    Zi(int x)
    {    //这一行是构造函数的第一行 super();
        super(9);
        System.out.println("zi constructor run...."+x); 
    } 
}

class ExtendsDemo3 {
    public static void main(String[] args) {
        Zi z = new Zi(6);
    }
}
