/**
 * 设计模式:解决某一类问题行之有效的解决办法(思想)
 * 单例(singleton) 设计模式
 * 学习设计模式必须先弄清楚它是解决什么问题的
 * 单例是解决什么问题的呢?
 * 他可以保证一个类的对象唯一性
 
 场景:比如多个程序都要使用一个配置文件中的数据,而且要实现数据的共享和交换
     必须要将这多个数据封装到一个对象中.而且多个程序操作的是同一个对象
     也就是说必须保证这个配置文件对象的唯一性.
 */
class SingleDemo {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}

class Demo
{
  

}
