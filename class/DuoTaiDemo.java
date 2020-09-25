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
 * [子类的特有方法如何调用]
    Animal a = new Dog();//Animal 是父类型, new Dog() 是子对象,
    但是父类型引用指向子类对象时,这就是让子类对象进行了类型的提升(向上转型),
    向上转型好处:提高了扩展性,隐藏了子类型.弊端:不能使用子类型方法
    如果想要使用子类型的特有方法,只有子类型可以用.
    可以向下转型,强制转换.
    Animal a = new Dog();
    (Dog) d = (Dog) a; //将a转型为Dog类型
    d.lookHome();
    向下转型什么时候用?当需要使用子类型的特有内容时.

    注意:无论向上还是向下转型,最终都是子类对象做着类型的变化.

    [向下转型的注意事项]
    Animal a = new Dog();
    Cat c = (Cat) a;  //向下转型 因为不明确具体子类对象类型,所以容易引发ClassCastException异常.
    所以为了避免这个问题,需要在向下转型前,做类型判断.
    判断类型用的是关键字 instanceof
    比如:
    if(a instanceof Cat)  //a指向的类型是Cat类型
    {
        Cat c = (Cat) a;
        c.catchMouse();
    }
    elseif(a instanceof Dog)
    {
        Dog d = (Dog) a;
        d.lookHome();
    }

 * [转型总结]
 1.什么时候使用向上转型呢?
    提高程序的扩展性,不关系子类型(子类型被隐藏)
    (需要用子类特有的方法吗?不需要,那就向上转型)
 2.什么时候使用向下转型呢?
    需要使用子类型的特有方法时.
    但是一定要使用 instanceof方法 进行类型判断,避免发生ClassCastException异常.

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

