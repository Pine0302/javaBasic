/**
 * 内部类其实也可以定义在外部类的局部位置上
 内部类定义在局部是，只能访问被final修饰的局部变量
 因为编译生成的class中直接操作那个最终的数值了

 Java 8更加智能：如果局部变量（本例子中的 y和z） 被匿名内部类访问，那么该局部变量相当于自动使用了final修饰。
 */

class Outer
{
    int num = 3;
    
    void method(){
        final int x = 5; //局部变量  
        int y = 6; //局部变量    如果被局部内部类访问，相当于添加了final 即 final y = 6;
        class Inner  //局部内部类,不能被成员修饰符修饰
        {
            void show(){
                System.out.println("Inner show run ..... "+ num);
                System.out.println("Inner show run ..... "+ x);
                System.out.println("Inner show run ..... "+ y);  
            }
        }
        new Inner().show();
    }

}

class InnerClassDemo3 {
    public static void main(String[] args) {
       /*
        Outer out = new Outer();
        out.method();
        */
        Outer2 out2 = new Outer2();
        out2.method();
        out2.function();
    }
}


class Outer2
{
    Object obj;
    void method(){
        int z = 6; //局部变量  如果被局部内部类访问，相当于添加了final
        class Inner  //局部内部类,不能被成员修饰符修饰
        {
            public String toString(){
                return "toString:"+z;
            }
        }
        obj = new Inner();
    }

    public void function(){
        System.out.println(obj.toString());
    }
}