/**
  代码简化
  匿名内部类，其实就是一个带有内容的子类对象
  格式： new 父类/接口(){子类内容}
  匿名内部类就是内部类的简化形式，
  别忘了，匿名内部类有前提，内部类必须要继承父类或者实现接口。
 */


interface Inter{
     void show1();
     void show2();
}
class Outer
{
    int num = 4;

    /*
    class Inner implements Inter
    {
        public void show1(){}
        public void show2(){}
    }
    */

    public void method()
    {
        /*
        Inner in  = new Inner();
        in.show1();
        in.show2();
        */
        Inter in = new Inter()
        {
            public void show1(){}
            public void show2(){}
        };
        in.show1();
        in.show2();
    }
}

class InnerClassDemo6 {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();
    }
}
