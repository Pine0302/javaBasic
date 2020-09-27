/**
 * 为什么内部类就能直接访问外部类中的成员呢？
 那是因为内部类其实持有了外部类的引用 外部类.this 
 对于静态内部类就不持有 外部类.this 二十直接使用外部类名 
 */

class Outer
{
    int num = 3;

    class Inner{
        int num = 4;
        void show(){
            int num = 5;
            //这些写法仅做理论参考，实践不要这么做
            System.out.println("num1 = "+ num);
            System.out.println("num2 = "+ this.num);
            System.out.println("num3 = "+ Outer.this.num);
        }
    }

    void method(){
        new Inner().show();
    }

}

class InnerClassDemo2 {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();
    }
}