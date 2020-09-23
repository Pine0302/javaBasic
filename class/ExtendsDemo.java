class ExtendsDemo {
    public static void main(String[] args) {
      Student stu = new Student();
      stu.age = 18;
      stu.name = "xiaoqiang";
      stu.study();
    }
}
/**
 * 面向对象的另一个特征：继承
 * 好处：提高了代码的复用性，让类与类产生了关系,给另一个特征 多态 提供了前提
 * 
 * 什么时候定义继承？
 * 必须保证类与类之间有所属关系（is a）关系。 xxx是zzz中的一种。
 * 苹果是水果中的一种，狗是犬科中的一种。
 * 
 * 在java中继承的体现：
 * java中允许单继承。不直接支持多继承，将多继承进行了其他方式的体现
 * 单继承：一个子类只能有一个父类
 * 多继承：一个子类可以有多个父类
 * 
 * 看上去，多继承很好！为什么。因为多个父类可以继承多个功能
 * 问题：如果多个父类具备了相同的功能(函数),调用就会产生不确定性，
 * 所以java保留了多继承的好处，改良了他的弊端。用多实现来体现，即将学到
 * 
 * java还支持多重继承，形成了继承体系。
 * 学习继承体系时，应该参阅顶层的类中的内容，了解这个体系的基本功能
 * 使用这个体系功能，需要创建最子类的对象       看顶层，建底层
 * 
 */
class Person
{
    String name; 
    int age;     
}

class Student extends Person
{
    void study(){
        System.out.println("good good study");
    }
}
class Worker extends Person
{
    void work(){
        System.out.println("work hard");
    }
}
