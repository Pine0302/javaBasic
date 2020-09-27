/**
  代码简化
  匿名内部类，其实就是一个带有内容的子类对象
  格式： new 父类/接口(){子类内容}
  匿名内部类就是内部类的简化形式，
  别忘了，匿名内部类有前提，内部类必须要继承父类或者实现接口。
  匿名内部类一般方法不要过多，否则阅读性会很差
 */


abstract class AbsDemo{
    abstract void show();
    abstract void show1();
}
class Outer
{
    int num = 3;
    /*
    private class Inner extends AbsDemo
    {
        //覆盖。重写抽象方法show
        void show(){
            System.out.println("num = "+ num);
        }
    }
    */

    // 获取内部类的对象
    /*
    public AbsDemo getObject()
    {
        return new Inner();
    }
    */

    public void method(){

       /**
        不想创建具体的子类型，还想创建AbsDemo的子类对象
        怎么实现呢？ 没有子类型，干脆直接使用父类型。
        可是在该例子中，父类型是抽象类，怎么new对象呢？
        抽象类之所以不能 new 对象，是因为抽象方法没重写，只要重写就可以了
        */
        AbsDemo a = new AbsDemo()    //这就是传说这的一个AbsDemo的子类对象。只不过这个对象有点胖，这是一个带着内容的子类对象
                        //这种写法叫做匿名内部类
        {
            //重写抽象的show 方法
            void show(){
                System.out.println("num = "+ num); 
            }
            void show1(){
                System.out.println("num1 = "+ num); 
            }
        };
        a.show();
        a.show1();
    }
}

class InnerClassDemo5 {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();
    }
}
