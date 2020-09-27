/**
  代码简化
  匿名内部类练习
 */

interface Inter{
    public void show();
}
class Outer
{

    //代码补足,要求使用匿名内部类
    public static Inter method()
    {
        //既然在Outer类中使用到了Inter的对象，可以使用内部类来完成。
        // 需要子类型，只要简化格式接口，因为接口中只有一个方法
        return new Inter()
        {
            @Override
            public void show(){}
        };
  
    }
}

class InnerClassDemo7 {
    public static void main(String[] args) {
        Outer.method().show();
        /**
         * Outer.method() Outer 类中有一个method 方法，这个方法是static 的
         * Outer.method().show();能调用show()的必然是对象，说明method方法运算完应该返回一个对象
           而且能调用Inter中的show方法，说明这个对象的类型Inter
         */
    }
}

//面试题。
class Outer2
{
    public void method()
    {
        new Object(); //这个是上帝类
        //以下两个对象有区别吗
        new Object(){
            public void show(){}
        }.show(); //这个是上帝的子类  //这个可以编译通过
        
        Object obj = new Object(){
            public void show(){}
        };
        obj.show(); //编译失败，为啥呢，因为匿名内部类是子类对象，当 Object obj指向时，就提升了Object。而Object类中没有定义show 方法，编译失败
        
        
    }
}

