/**
 * 细节
 * 1.如果子类的构造函数第一行写了this调用了本类的其他构造函数,那么在该构造函数中海油super()调用父类的语句吗?
 * 没有的,因为this()或者super(),只能定义在构造函数的第一行,因为初始化的动作要先执行
 * 
 * 2.父类构造函数里面是否有隐式的super()吗?
 * 也是有的,只要是构造函数默认的第一行都是super();
 * 父类的父类是谁呢?super()调用的到底是谁的构造函数?
 * Java体系在设计时,定义了一个所有对象的父类.Object
 * 
 * 总结:
 * 类中的构造函数默认第一行都有隐式的super()语句,在访问父类中的构造函数
 * 所以父类的构造函数可以给自己的对象初始化,也可以给自己子类对象初始化
 * 如果默认的隐式super语句没有对应的构造函数,必须在构造函数中通过this或者super的形式明确调用的构造函数
 */
class Fu extends Object
{
    Fu()
    {
        System.out.println("fu constructor empty run...."); 
    } 
    Fu(int x)
    {
        System.out.println("fu constructor run...."+x); 
    } 
}

class Zi extends Fu
{
    Zi(){   //这一行是构造函数的第一行 super();
        //super();
        System.out.println("zi constructor empty run...."); 
    }

    Zi(int x)
    {  
        this();
        System.out.println("zi constructor run...."+x); 
    } 
}

class ExtendsDemo4 {
    public static void main(String[] args) {
        Zi z = new Zi(6);
    }
}


//子类的实例化过程的应用.也是super调用的应用.
// 只要使用弗雷德指定初始化动作,就在子类中通过super(参数列表)的格式进行调用
class Person
{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

}

class Student extends Person
{
    public Student(String name,int age){
       super(name,age); 
    }
}

class Worker extends Person
{
    public Worker(String name,int age){
       super(name,age); 
    }
}
