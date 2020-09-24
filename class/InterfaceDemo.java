/**
 * 当一个抽象类中的方法全是抽象的。这是，可以通过另一种特殊形式体现
 * interface
/**
 * 【接口的定义格式】
 * 接口中的成员已经被限定为固定的几种 先介绍两种 
 * 1.定义变量，但是变量必须有固定的修饰符修饰，public static final 所以接口中的变量也称之为常量 
 * 2.定义方法，方法也有固定的修饰符，public abstract 
 * 接口中的成员都是公共的
 * 
 * 【接口的特点】
 * 1.接口不可以创建对象
 * 2.子类必须覆盖掉接口所有的抽象方法后，子类才可以实例化，否则子类是一个抽象类
 */
interface Demo // 定义一个名称为demo的接口
{
    public static final int NUM = 3;

    public abstract void show1(); //

    public abstract void show2(); //
}

//定义子类去覆盖接口中的方法
//类与接口的关系是 实现 通过关键字 implements
class DemoImp implements Demo  //子类实现demo接口
{
    //重写接口中的方法
    public void show1(){}
    public void show2(){}

}

class InterfaceDemo  {
    public static void main(String[] args) {
        C c = new C();
        c.show();
    }
 }

/**
 * 【接口最重要的提现】
 * 解决了多继承的弊端。将多继承这种机制在java中通过多实现完成了
 */
/**
 * 【怎么解决多继承的弊端呢？】
 * 多继承时，当多个父类有相同功能是，子类调用会产生不确定性
 * 其实核心原因在于，多继承父类功能中有主体，而导致调用运行时，不确定运行哪个主体内容
 * 为什么多实现就解决了呢？
 * 因为接口中的功能都没有方法体，由子类来明确。
 */
interface A{
    void show();
    void show1();
}

interface B{
    void show();
    void show2();
}

class C implements A,B  //多实现，同时实现多个接口
{
    public void show1(){}
    public void show2(){}
    public void show(){}
}

/**
 * 【基于接口的扩展】
 */

 class Fu
 {
    public void show(){}
 }

 interface inter
 {
    public void show1();
 }
 //子类通过继承父类扩展功能，通过继承扩展的功能都是子类应该具备的基础功能
 //如果子类想要继续扩展其他类中的功能呢？这时通过实现接口来完成
 //接口的出现避免了单继承的局限性
 //父类中定义了事物的基本功能
 //接口中定义了事物的扩展功能
 class Zi extends Fu implements inter
 {
    public void show1(){}
 }

/**
 * 【接口出现后的一些小细节】
 * 1.类与类之间是继承关系 （is a),类与接口之间是实现（like a）关系，
 * 接口与接口质检室继承关系,而且可以多继承
 */
interface InterA
{
    void showA();
}

interface InterAA
{
    void showAA();
}

interface InterB extends InterA,InterAA
{
    void showB();
}

class Test implements InterB
{
    public void showA(){}
    public void showAA(){}
    public void showB(){}
}