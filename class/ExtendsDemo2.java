/**
 * 子父类中成员函数相同的情况
 * 特殊情况：
 * 子父类运行同样一个函数 
 * 运行结果：子类的函数在运行
 * 这种情况是函数的另一个特性，重写(覆盖、复写) override
 * 
 * 重写什么时候用？
 * 重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
 * 
 * 重写的注意事项
 * 1.子类覆盖父类，必须保证权限要大约或者等于父类的权限
 *   如果父类是公有的，子类必须公有 （父类的私有不在此列）
 * 2.静态覆盖静态（父类的是静态，子类必须静态，反之亦然）
 * 
 * 写法上注意：必须一模一样（函数名，返回值类型，形参）
 */
class Fu
{
    void show(){
        System.out.println("fu show1 run"); 
    } 
}

class Zi extends Fu
{
    void show(){
        System.out.println("zi show2 run"); 
    } 
}

class ExtendsDemo2 {
    public static void main(String[] args) {
        Zi z = new Zi();
        z.show(); 
    }
}
