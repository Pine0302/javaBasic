import org.w3c.dom.ls.LSException;

/**
 * 多态
 *【体现】
 *    父类的引用或者接口的引用指向了自己的子类对象
 *    Dog d = new Dog();    //Dog对象的类型是Dog类型
 *    Animal a = new Dog(); //Dong对象的类型右边是Dog类型，左边Animal类型
 *【好处】
 *    提高了程序的扩展性
 *【弊端】  
 *    通过父类引用操作子类对象时，只能使用父类中已有的方法，不能操作子类持有的方法    
 *【前提】
 *    1.必须有关系：继承/实现
 *    2.通常都有重写操作。  
 * 调父类的方法，运行子类的内容
 */

class DuotaiDemo  {
    public static void main(String[] args) {
        Animal a = new Dog();
        Animal b = new Cat();
        a.eat();
        b.eat();
    }
}

class Dog extends Animal
{
    public void eat()
    {
        System.out.println("eat bone");
    }

    public void lookHome()
    {
        System.out.println("look home");
    }
}

class Cat extends Animal
{
    public void eat()
    {
        System.out.println("eat fish");
    }

    public void catchMouse()
    {
        System.out.println("catch mouse");
    }
}

abstract class Animal
{
    public abstract void eat();
}

