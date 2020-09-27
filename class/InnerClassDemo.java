/**
 * 内部类
 当A类中的内容要被B类访问，而A类还需要创建B类的对象，访问B类的内容时，
 这时，可以将B类定义到A类的内部，这样访问更为便捷
 * 
 * 访问方式： 
 内部类可以直接访问外部类的所有成员，包含私有的
 外部类要是想内部类的成员，必须创建内部类的对象

 当描述事物时，事物的内部还有事物，这个内部的事物还在访问外部事物的内容。
 这时就将这个事物通过内部类来描述。

 *【内部类被访问的方式】
 情况1：内部类在成员位置上被访问方式。
    成员是可以被指定的修饰符锁修饰的。
    public:不多见，更多的时候，内部类已经被封装到了外部类中，不直接对外提供。
    static:
    

 */

class Outer
{
    private  int num = 4;
    private static int num2 = 8;
    public class Inner{

        void show(){
            System.out.println("Inner run show num = "+num);
        }

        // static void show2(){}  //非静态内部类中不允许定义静态成员，仅运行在非静态内部类中定义静态常量 static final
        // 因为 static final int x=3 ，相当于定义一个静态常量 3
    }
    /**
     * 内部类被静态修饰后，随着outer的加载而加载，可以把一个静态的内部类理解为一个外部类
     */
    static class Inner2{
        void show2()
        {
            System.out.println("Inner2 show run num2 = "+num2);
        }
        static void staticShow()
        {
            System.out.println("Inner2 staticShow run num2 = "+num2); 
        }
    }
    
    void method(){
        Inner in = new Inner();//Outer.Inner in = new Outer.Inner();
        in.show();
    }

}

class InnerClassDemo {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();

        //情况1：直接访问Outer中的Inner内部类非静态成员
        //内部类作为成员，应该先有外部类对象，再有内部类对象
        Outer.Inner in = new Outer().new Inner();
        in.show();

        //情况2：对静态内部类中的非静态成员（show2）进行调用。
        //因为内部类是静态，所以不需要创建Outer的对象，直接创建内部类对象就可以了
        Outer.Inner2 in2 = new Outer.Inner2();
        in2.show2();

        //如果静态内部类中有静态成员，该如何访问呢？既然静态内部类已随着外部类加载，而且静态成员随着列加载而加载
        //就不需要对象，直接用类名调用即可
        Outer.Inner2.staticShow();


    }
}