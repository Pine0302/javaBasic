class Demo {
    int x = 9; // 成员变量有两次初始化，一次默认初始化，一次显示初始化
    { // 构造代码块，只要创建对象就会被调用，在成员变量显示初始化之后执行。给所有对象初始化；构造函数只给对应对象针对性初始化。
      // 这里可以定义不同构造函数的共性代码
        System.out.println("code run----" + x);
        System.out.println("哈哈哈哈");
    }
    Demo() {
        System.out.println("demo run");
    }
    Demo(int x) {
        System.out.println("demo run...." + x);
    }

}

class ConstructorCodeDemo {
    public static void main(String[] args) {
        new Demo();
        new Demo(5);
        { //局部代码块 作用：可以控制局部变量的生命周期，类似for循环中的x
            int x = 10;
            System.out.println("demo run...." + x);
        }
       // System.out.println("demo run...." +x);
        System.out.println("demo run....");
    }
}